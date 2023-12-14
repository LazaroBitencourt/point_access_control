package point_access_control.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import point_access_control.model.Calendario;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long> {
}
