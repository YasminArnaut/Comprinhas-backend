package br.com.comprinhas.controller;

import br.com.comprinhas.dto.CompraRequest;
import br.com.comprinhas.dto.ListaCompraRequest;
import br.com.comprinhas.useCase.CompraUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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
    @PostMapping("/lista")
    public ResponseEntity<List<CompraRequest>> cadastrarLista(
            @Valid @RequestBody ListaCompraRequest request) {

        List<CompraRequest> compras =
                compraUseCase.cadastrarLista(request.getCompras());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(compras);
    }
}
