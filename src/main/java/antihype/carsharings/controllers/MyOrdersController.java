package antihype.carsharings.controllers;

import antihype.carsharings.domain.CarAdvert;
import antihype.carsharings.domain.User;
import antihype.carsharings.services.CarAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class MyOrdersController {
    private CarAdvertService service;

    @GetMapping("/myorders")
    public String getPage(@AuthenticationPrincipal User user, Model model) {
        Set<CarAdvert> carAdvertsByRenter = service.getCarAdvertsByRenter(user);
        model.addAttribute("carAdverts", carAdvertsByRenter);
        return "myorders";
    }


    @Autowired
    public void setService(CarAdvertService service) {
        this.service = service;
    }
}
