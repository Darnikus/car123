package antihype.carsharings.repositories;

import antihype.carsharings.domain.CarAdvert;
import antihype.carsharings.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CarAdvertRepository extends JpaRepository<CarAdvert, Long> {
    List<CarAdvert> findByAuthor(User author);
    List<CarAdvert> findByText(String text);
    Optional<CarAdvert> findById(Long id);

    @Query("from CarAdvert c where ?1 member of c.renters")
    Set<CarAdvert> findByRenters(User user);
}
