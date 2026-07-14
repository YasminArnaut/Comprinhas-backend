package br.com.comprinhas.useCase;
import br.com.comprinhas.dto.CompraRequest;

import java.util.List;

public interface CompraUseCase {
    CompraRequest cadastrar(CompraRequest compraRequest);
    List<CompraRequest> cadastrarLista(List<CompraRequest> compras);


}
