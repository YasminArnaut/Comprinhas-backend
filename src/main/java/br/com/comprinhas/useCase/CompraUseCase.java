package br.com.comprinhas.useCase;
import br.com.comprinhas.dto.CompraRequest;
import br.com.comprinhas.model.Compra;

import java.util.List;

public interface CompraUseCase {
    CompraRequest cadastrar(CompraRequest compraRequest);
    List<CompraRequest> cadastrarLista(List<CompraRequest> compras);
    void deletar(Long id);
    List<Compra> listar();
}
