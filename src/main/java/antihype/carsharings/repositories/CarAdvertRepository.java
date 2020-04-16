package antihype.carsharings.repositories;

import antihype.carsharings.domain.CarAdvert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarAdvertRepository extends JpaRepository<CarAdvert, Long> {
}
