package br.com.comprinhas.dto;

import javax.validation.Valid;
import java.util.List;

public class ListaCompraRequest {

        @Valid
        private List<CompraRequest> compras;

        public List<CompraRequest> getCompras() {
                return compras;
        }

        public void setCompras(List<CompraRequest> compras) {
                this.compras = compras;
        }

}
