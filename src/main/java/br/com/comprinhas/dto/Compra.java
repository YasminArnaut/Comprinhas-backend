package br.com.comprinhas.dto;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;


public class Compra {
    @Size(min = 5, max = 15)
    private String nomeProduto;

    @Size(min = 10, max = 20)
    private String descricao;

    private BigDecimal valor;

    private LocalDate dataCompra;
    @Size(min = 5, max = 15)
    private String nomeLoja;

    private LocalDate dataEntrega;

    private String status;


    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

