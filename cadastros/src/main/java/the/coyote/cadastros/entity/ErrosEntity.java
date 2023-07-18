package the.coyote.cadastros.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrosEntity {
    
    private Long timestamp;
    private Integer status;
    private String message;

}
