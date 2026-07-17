package br.com.comprinhas.useCaseTests;

import br.com.comprinhas.dto.CompraRequest;
import br.com.comprinhas.model.Compra;
import br.com.comprinhas.repository.CompraRepository;
import br.com.comprinhas.useCase.CompraUseCaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CompraUseCaseImplTests {
    private CompraRepository repository;
    private CompraUseCaseImpl useCase;

    @BeforeEach
    void setup() {
        repository = mock(CompraRepository.class);
        useCase = new CompraUseCaseImpl(repository);
    }

    @Test
    void deveCadastrarCompraComStatusComprado() {
        CompraRequest request = criarCompraRequest();
        CompraRequest retorno = useCase.cadastrar(request);
        ArgumentCaptor<Compra> captor = ArgumentCaptor.forClass(Compra.class);
        verify(repository, times(1)).save(captor.capture());
        Compra compraSalva = captor.getValue();
        assertEquals("Notebook", compraSalva.getNomeProduto());
        assertEquals("Dell Gamer", compraSalva.getDescricao());
        assertEquals(new BigDecimal("3500.00"), compraSalva.getValor());
        assertEquals("Magazine", compraSalva.getNomeLoja());
        assertEquals("Comprado", compraSalva.getStatus());
        assertEquals("Comprado", retorno.getStatus());
        assertSame(request, retorno);
    }

    @Test
    void deveCadastrarListaDeComprasComStatusComprado() {
        CompraRequest compra1 = criarCompraRequest();
        CompraRequest compra2 = criarCompraRequest();
        compra2.setNomeProduto("Teclado");
        List<CompraRequest> requests = List.of(compra1, compra2);
        List<CompraRequest> retorno = useCase.cadastrarLista(requests);
        ArgumentCaptor<List<Compra>> captor = ArgumentCaptor.forClass(List.class);
        verify(repository, times(1)).saveAll(captor.capture());
        List<Compra> comprasSalvas = captor.getValue();
        assertEquals(2, comprasSalvas.size());
        assertEquals("Comprado", comprasSalvas.get(0).getStatus());
        assertEquals("Comprado", comprasSalvas.get(1).getStatus());
        assertEquals("Comprado", retorno.get(0).getStatus());
        assertEquals("Comprado", retorno.get(1).getStatus());
        assertEquals(2, retorno.size());
    }

    private CompraRequest criarCompraRequest() {
        CompraRequest request = new CompraRequest();
        request.setNomeProduto("Notebook");
        request.setDescricao("Dell Gamer");
        request.setValor(new BigDecimal("3500.00"));
        request.setDataCompra(LocalDate.now());
        request.setNomeLoja("Magazine");
        request.setDataEntrega(LocalDate.now().plusDays(5));
        return request;
    }
}
