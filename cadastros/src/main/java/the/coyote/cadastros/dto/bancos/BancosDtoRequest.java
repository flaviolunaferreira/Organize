package the.coyote.cadastros.dto.bancos;

import java.time.LocalDate;

import the.coyote.cadastros.entity.BancosEntity;

public class BancosDtoRequest {

    private Integer numero;
    private String nome;
    private LocalDate cadastro;

    public BancosEntity newBanco() {
        return new BancosEntity(numero, nome, cadastro);
    }

}
