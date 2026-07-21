package br.com.comprinhas.useCase;

import br.com.comprinhas.dto.CompraRequest;
import br.com.comprinhas.dto.CompraUpdateRequest;

public interface CompraUseCase {
    CompraRequest cadastrar(CompraRequest compraRequest);
    CompraRequest atualizar(Long id, CompraUpdateRequest request);
    void deletar(Long id);

}
