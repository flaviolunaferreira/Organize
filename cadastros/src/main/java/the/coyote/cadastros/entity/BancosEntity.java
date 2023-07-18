package the.coyote.cadastros.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BancosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;
    private String nome;
    private LocalDate cadastro;

    public BancosEntity(String nome, LocalDate cadastro) {
        this.nome = nome;
        this.cadastro = cadastro;
    }

}
