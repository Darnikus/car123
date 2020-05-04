package antihype.carsharings.repositories;

import antihype.carsharings.domain.CarAdvert;
import antihype.carsharings.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarAdvertRepository extends JpaRepository<CarAdvert, Long> {
    List<CarAdvert> findByAuthor(User author);
    List<CarAdvert> findByText(String text);
    Optional<CarAdvert> findById(Long id);
}
