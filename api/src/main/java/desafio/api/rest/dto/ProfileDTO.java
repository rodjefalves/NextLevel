package desafio.api.rest.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ProfileDTO {

    private Integer id;

    private String nome;

    private String telefone;

    private String email;

    private String data_nascimento;

    private String link_foto;
}
