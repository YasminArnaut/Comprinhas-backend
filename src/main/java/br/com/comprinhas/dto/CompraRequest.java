package br.com.comprinhas.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CompraRequest {

    private Long id;
    @NotBlank
    @Size(min = 5, max = 15)
    private String nomeProduto;
    @NotBlank
    @Size(min = 3, max = 20)
    private String descricao;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private LocalDate dataCompra;
    @NotBlank
    @Size(min = 5, max = 15)
    private String nomeLoja;
    @NotNull
    private LocalDate dataEntrega;
    private String status;

}

