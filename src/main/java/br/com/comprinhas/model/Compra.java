package br.com.comprinhas.model;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProduto;

    @Size(min = 10, max = 20)
    private String descricao;

    private BigDecimal valor;

    private LocalDate dataCompra;

    @Size(min = 5, max = 15)
    private String nomeLoja;

    private LocalDate dataEntrega;

    private String status;
}
