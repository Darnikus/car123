package antihype.carsharings.controllers;

import antihype.carsharings.domain.CarAdvert;
import antihype.carsharings.domain.User;
import antihype.carsharings.services.CarAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MySharesController {

    CarAdvertService service;

    @GetMapping("/myshares")
    public String getPage(
            @AuthenticationPrincipal User user,
            Model model) {
        List<CarAdvert> carAdvertsByAuthor = service.getCarAdvertsByAuthor(user);
        model.addAttribute("carAdverts", carAdvertsByAuthor);
        return "myshares";
    }

    @PostMapping("/myshares")
    public String addCarAdvert(
            @AuthenticationPrincipal User user,
            @RequestParam String text, Model model) {
        CarAdvert carAdvert = new CarAdvert(text, user);
        service.saveCarAdvert(carAdvert);
        return "redirect:/myshares";
    }


    @Autowired
    public void setService(CarAdvertService service) {
        this.service = service;
    }
}
