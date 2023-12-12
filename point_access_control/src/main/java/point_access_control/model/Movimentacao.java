package point_access_control.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movimentacao {

        @NoArgsConstructor
        @AllArgsConstructor
        @EqualsAndHashCode
        @Embeddable
       public class MovimentacaoId implements Serializable{  // Forma de criação de um id de chaves compostas.
           private Long idMovimento;
           private Long idUsuario;
       }
        @EmbeddedId
        private MovimentacaoId id;
        private LocalDateTime dataEntrada;
        private LocalDateTime dataSaida;
        private BigDecimal periodo;
        @ManyToOne
        private Ocorrencia ocorrencia;
        @ManyToOne
        private Calendario calendario;
}
