package br.com.comprinhas.useCase;

import br.com.comprinhas.dto.CompraRequest;
import br.com.comprinhas.dto.CompraUpdateRequest;
import br.com.comprinhas.model.Compra;
import br.com.comprinhas.repository.CompraRepository;
import org.springframework.stereotype.Component;

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

        Compra compraSalva = repository.save(compra);

        request.setId(compraSalva.getId());
        request.setStatus("Comprado");

        return request;

    }

    @Override
    public void deletar(Long id) {

        System.out.println("Tentando remover ID: " + id);

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Compra não encontrada com id: " + id);
        }

        repository.deleteById(id);

        System.out.println("Removido ID: " + id);
    }
    @Override
    public CompraRequest atualizar(Long id, CompraUpdateRequest request) {

        Compra compra = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Compra não encontrada"));
        if (request.getNomeProduto() != null) {
            compra.setNomeProduto(request.getNomeProduto());
        }

        if (request.getNomeProduto() != null) {
            compra.setNomeProduto(request.getNomeProduto());
        }

        if (request.getDescricao() != null) {
            compra.setDescricao(request.getDescricao());
        }

        if (request.getValor() != null) {
            compra.setValor(request.getValor());
        }

        if (request.getDataCompra() != null) {
            compra.setDataCompra(request.getDataCompra());
        }

        if (request.getNomeLoja() != null) {
            compra.setNomeLoja(request.getNomeLoja());
        }

        if (request.getDataEntrega() != null) {
            compra.setDataEntrega(request.getDataEntrega());
        }


        Compra compraAtualizada = repository.save(compra);

        CompraRequest response = new CompraRequest();
        response.setId(compraAtualizada.getId());
        response.setNomeProduto(compraAtualizada.getNomeProduto());
        response.setDescricao(compraAtualizada.getDescricao());
        response.setValor(compraAtualizada.getValor());
        response.setDataCompra(compraAtualizada.getDataCompra());
        response.setNomeLoja(compraAtualizada.getNomeLoja());
        response.setDataEntrega(compraAtualizada.getDataEntrega());
        response.setStatus(compraAtualizada.getStatus());

        return response;
    }

}