package point_access_control.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import point_access_control.model.TipoData;

@Repository
public interface TipoDataRepository extends JpaRepository<TipoData, Long> {
}
