package the.coyote.cadastros.dto.bancos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import the.coyote.cadastros.entity.BancosEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BancosDtoRequest {

    private String nome;

    public BancosEntity newBanco() {
        LocalDate dataAtual = LocalDate.now();
        return new BancosEntity(nome , dataAtual);
    }

}
