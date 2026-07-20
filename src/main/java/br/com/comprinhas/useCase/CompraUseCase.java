package br.com.comprinhas.useCase;

import br.com.comprinhas.dto.CompraRequest;

public interface CompraUseCase {
    CompraRequest cadastrar(CompraRequest compraRequest);

    void deletar(Long id);

}
