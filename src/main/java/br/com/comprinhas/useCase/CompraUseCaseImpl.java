package br.com.comprinhas.useCase;

import br.com.comprinhas.dto.Compra;
import org.springframework.stereotype.Component;

@Component
public class CompraUseCaseImpl implements CompraUseCase {

    @Override
    public Compra cadastrar(Compra compra) {
        compra.setStatus("Comprado");
        return null;
    }
}
