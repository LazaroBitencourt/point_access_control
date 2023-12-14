package point_access_control.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import point_access_control.model.Localidade;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {
}
