package antihype.carsharings.services;

import antihype.carsharings.domain.CarAdvert;
import antihype.carsharings.domain.User;
import antihype.carsharings.repositories.CarAdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CarAdvertService {
    private CarAdvertRepository repository;

    public void saveCarAdvert(CarAdvert carAdvert) {
        repository.save(carAdvert);
    }

    public List<CarAdvert> getAllCarAdverts() {
        return repository.findAll();
    }

    public List<CarAdvert> getCarAdvertsByAuthor(User author) {
        return repository.findByAuthor(author);
    }

    public List<CarAdvert> getCarAdvertsByText(String text) { return repository.findByText(text); }

    public Optional<CarAdvert> getCarAdvertById(Long id) { return repository.findById(id); }

    public void deleteCarAdvert(CarAdvert carAdvert) { repository.delete(carAdvert); }

    public Set<CarAdvert> getCarAdvertsByRenter(User user) { return repository.findByRenters(user); }

    @Autowired
    public void setRepository(CarAdvertRepository repository) {
        this.repository = repository;
    }
}
