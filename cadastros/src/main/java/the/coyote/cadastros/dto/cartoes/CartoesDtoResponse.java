package the.coyote.cadastros.dto.cartoes;

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
public class CartoesDtoResponse {

    private Long id;
    private String numeroDoCartao;
    private LocalDate dataDoVencimento;
    private LocalDate validade;
    private Double limite;
    private BancosEntity banco;

}
