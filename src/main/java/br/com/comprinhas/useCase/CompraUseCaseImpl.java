package br.com.comprinhas.useCase;

import br.com.comprinhas.dto.CompraRequest;
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
            throw new RuntimeException("Compra não encontrada");
        }

        repository.deleteById(id);

        System.out.println("Removido ID: " + id);
    }

}