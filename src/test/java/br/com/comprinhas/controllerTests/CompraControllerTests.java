package br.com.comprinhas.controllerTests;

import br.com.comprinhas.controller.CompraController;
import br.com.comprinhas.dto.CompraRequest;
import br.com.comprinhas.useCase.CompraUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CompraController.class)
public class CompraControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CompraUseCase compraUseCase;
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Test
    void deveCadastrarCompraComSucesso() throws Exception {
        CompraRequest request = criarCompraValida();
        given(compraUseCase.cadastrar(any(CompraRequest.class))).willReturn(request);
        mockMvc.perform(post("/compras").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request))).andExpect(status().isCreated()).andExpect(jsonPath("$.nomeProduto").value("Notebook")).andExpect(jsonPath("$.descricao").value("Dell Gamer")).andExpect(jsonPath("$.nomeLoja").value("Magazine"));
        verify(compraUseCase).cadastrar(any(CompraRequest.class));
    }

    @Test
    void deveCadastrarListaDeComprasComSucesso() throws Exception {
        CompraRequest compra = criarCompraValida();
        ListaCompraRequest lista = new ListaCompraRequest();
        lista.setCompras(List.of(compra));
        given(compraUseCase.cadastrarLista(anyList())).willReturn(List.of(compra));
        mockMvc.perform(post("/compras/lista").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(lista))).andExpect(status().isCreated()).andExpect(jsonPath("$[0].nomeProduto").value("Notebook")).andExpect(jsonPath("$[0].descricao").value("Dell Gamer"));
        verify(compraUseCase).cadastrarLista(anyList());
    }

    @Test
    void deveRetornarBadRequestQuandoNomeProdutoForInvalido() throws Exception {
        CompraRequest request = criarCompraValida();
        request.setNomeProduto("");
        mockMvc.perform(post("/compras").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request))).andExpect(status().isBadRequest());
        verifyNoInteractions(compraUseCase);
    }

    @Test
    void deveRetornarBadRequestQuandoDescricaoForInvalidaNaLista() throws Exception {
        CompraRequest compra = criarCompraValida();
        compra.setDescricao("");
        ListaCompraRequest lista = new ListaCompraRequest();
        lista.setCompras(List.of(compra));
        mockMvc.perform(post("/compras/lista").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(lista))).andExpect(status().isBadRequest());
        verifyNoInteractions(compraUseCase);
    }

    private CompraRequest criarCompraValida() {
        CompraRequest compra = new CompraRequest();
        compra.setNomeProduto("Notebook");
        compra.setDescricao("Dell Gamer");
        compra.setValor(new BigDecimal("3500.00"));
        compra.setDataCompra(LocalDate.now());
        compra.setNomeLoja("Magazine");
        compra.setDataEntrega(LocalDate.now().plusDays(5));
        compra.setStatus("PENDENTE");
        return compra;
    }
}

