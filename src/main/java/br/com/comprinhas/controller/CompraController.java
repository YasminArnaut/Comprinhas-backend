package br.com.comprinhas.controller;

import br.com.comprinhas.dto.Compra;
import br.com.comprinhas.useCase.CompraUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final CompraUseCase compraUseCase;

    public CompraController(CompraUseCase compraUseCase) {
        this.compraUseCase = compraUseCase;
    }

    @PostMapping
    public ResponseEntity<Compra> cadastrar(@Valid @RequestBody Compra compra) {
        Compra compraCadastrada = compraUseCase.cadastrar(compra);
        return ResponseEntity.status(HttpStatus.CREATED).body(compraCadastrada);
    }
}
