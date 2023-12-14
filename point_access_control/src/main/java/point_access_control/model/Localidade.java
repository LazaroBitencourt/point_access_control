package point_access_control.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Localidade {

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class LocalidadeId implements Serializable {
        private Long idLocalidade;
        private Long idNivelAcesso;
    }
    @EmbeddedId
    private LocalidadeId id;
    private String descricao;
    @ManyToOne
    private NivelAcesso nivelAcesso;
}
