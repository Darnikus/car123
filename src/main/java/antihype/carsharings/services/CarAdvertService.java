package antihype.carsharings.services;

import antihype.carsharings.domain.CarAdvert;
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

    @Autowired
    public void setRepository(CarAdvertRepository repository) {
        this.repository = repository;
    }
}
