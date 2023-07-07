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
public class BancosDtoResponse {

    private Integer numero;
    private String nome;
    private LocalDate cadastro;

    public BancosDtoResponse(BancosEntity bancos) {
        this.setNumero(bancos.getNumero());
        this.setNome(bancos.getNome());
        this.setCadastro(bancos.getCadastro());
    }

}
