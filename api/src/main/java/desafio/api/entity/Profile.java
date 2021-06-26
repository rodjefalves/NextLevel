package desafio.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "usuario_sequence")
    private Integer id;

    @Column
    private String nome;

    @Column
    private String telefone;

    @Column
    private String email;

    @Column
    private String data_nascimento;

    @Column
    private String link_foto;
}
