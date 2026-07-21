package br.com.comprinhas.controller;

import br.com.comprinhas.dto.CompraRequest;
import br.com.comprinhas.dto.CompraUpdateRequest;
import br.com.comprinhas.useCase.CompraUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/compras")
public class CompraController {


    private final CompraUseCase compraUseCase;

    public CompraController(CompraUseCase compraUseCase) {
        this.compraUseCase = compraUseCase;
    }

    @PostMapping
    public ResponseEntity<CompraRequest> cadastrar(
            @Valid @RequestBody CompraRequest compraRequest) {

        CompraRequest compraCadastrada = compraUseCase.cadastrar(compraRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(compraCadastrada);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        compraUseCase.deletar(id);
        return ResponseEntity.ok("Compra removida com sucesso");
    }
    @PatchMapping("/{id}")
    public ResponseEntity<CompraRequest> atualizar(
            @PathVariable Long id,
            @RequestBody CompraUpdateRequest request) {

        CompraRequest compraAtualizada = compraUseCase.atualizar(id, request);

        return ResponseEntity.ok(compraAtualizada);
    }
}
