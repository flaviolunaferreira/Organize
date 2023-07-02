package the.coyote.usuarios.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorEntity {

    private Long timestamp;
    private Integer status;
    private String error;

}
