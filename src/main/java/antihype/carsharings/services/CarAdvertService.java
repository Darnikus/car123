package antihype.carsharings.services;

import antihype.carsharings.domain.CarAdvert;
import antihype.carsharings.domain.User;
import antihype.carsharings.repositories.CarAdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    public void setRepository(CarAdvertRepository repository) {
        this.repository = repository;
    }
}
