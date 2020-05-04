package antihype.carsharings.controllers;

import antihype.carsharings.domain.CarAdvert;
import antihype.carsharings.domain.User;
import antihype.carsharings.services.CarAdvertService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
public class CarAdvertController {

    private CarAdvertService service;


    @GetMapping("/home")
    public String showCarAdverts(Model model) {
        Iterable<CarAdvert> carAdverts = service.getAllCarAdverts();
        model.addAttribute("carAdverts", carAdverts);
        return "home";
    }

//    @PostMapping("/home")
//    public String addCarAdvert(
//            @AuthenticationPrincipal User user,
//            @RequestParam String text, Model model) {
//        CarAdvert carAdvert = new CarAdvert(text, user);
//        service.saveCarAdvert(carAdvert);
//        return "redirect:/home";
//    }

    @GetMapping(value = "/order", params = "id")
    public String showCarAdvertDetails(@RequestParam("id") Long id, Model model) {
        CarAdvert carAdvert = service.getCarAdvertById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
        model.addAttribute("carAdvert", carAdvert);
        return "details";
    }

    @Autowired
    public void setService(CarAdvertService service) {
        this.service = service;
    }
}
