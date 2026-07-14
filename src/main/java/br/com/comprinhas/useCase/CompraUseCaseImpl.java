package br.com.comprinhas.useCase;

import br.com.comprinhas.dto.CompraRequest;
import br.com.comprinhas.model.Compra;
import br.com.comprinhas.repository.CompraRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompraUseCaseImpl implements CompraUseCase {

    private final CompraRepository repository;

    public CompraUseCaseImpl(CompraRepository repository) {
        this.repository = repository;
    }


    @Override
    public CompraRequest cadastrar(CompraRequest request) {
        Compra compra = new Compra();

        compra.setNomeProduto(request.getNomeProduto());
        compra.setDescricao(request.getDescricao());
        compra.setValor(request.getValor());
        compra.setDataCompra(request.getDataCompra());
        compra.setNomeLoja(request.getNomeLoja());
        compra.setDataEntrega(request.getDataEntrega());
        compra.setStatus("Comprado");

        repository.save(compra);

        request.setStatus("Comprado");

        return request;

    }

    @Override
    public List<CompraRequest> cadastrarLista(List<CompraRequest> comprasRequest) {

        List<Compra> compras = comprasRequest.stream()
                .map(request -> {

                    Compra compra = new Compra();

                    compra.setNomeProduto(request.getNomeProduto());
                    compra.setDescricao(request.getDescricao());
                    compra.setValor(request.getValor());
                    compra.setDataCompra(request.getDataCompra());
                    compra.setNomeLoja(request.getNomeLoja());
                    compra.setDataEntrega(request.getDataEntrega());
                    compra.setStatus("Comprado");

                    request.setStatus("Comprado");

                    return compra;
                })
                .toList();

        repository.saveAll(compras);
        comprasRequest.forEach(request ->
                request.setStatus("Comprado")
        );

        return comprasRequest;
    }
}