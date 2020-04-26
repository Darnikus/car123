package antihype.carsharings.controllers;

import antihype.carsharings.domain.CarAdvert;
import antihype.carsharings.domain.User;
import antihype.carsharings.services.CarAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MySharesController {

    CarAdvertService service;

    @GetMapping("/myshares")
    public String getPage(
            @AuthenticationPrincipal User user,
            Model model) {
//        List<CarAdvert> allCarAdverts = service.getAllCarAdverts().stream().filter(u -> u.getAuthor().equals(user)).collect(Collectors.toList());

        List<CarAdvert> carAdvertsByAuthor = service.getCarAdvertsByAuthor(user);
        model.addAttribute("carAdverts", carAdvertsByAuthor);
        return "myshares";
    }


    @Autowired
    public void setService(CarAdvertService service) {
        this.service = service;
    }
}
