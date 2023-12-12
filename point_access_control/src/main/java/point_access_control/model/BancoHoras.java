package point_access_control.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class BancoHoras {

        @NoArgsConstructor
        @AllArgsConstructor
        @EqualsAndHashCode
        @Embeddable
        public class BancoHorasId implements Serializable{
            private Long idBancoHoras;
            private Long idmovimentacao;
            private Long idusurio;
        }

        @EmbeddedId
        private BancoHorasId id;
        private LocalDateTime dataTrabalhada;
        private BigDecimal quantidadeHoras;
        private BigDecimal saldoHoras;
}
