package tech.juniorlima.clickbus.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.juniorlima.clickbus.model.PlaceModel;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceModel, Long> {
  Optional<List<PlaceModel>> findByNameIgnoreCase(String name);
}
