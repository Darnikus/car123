package antihype.carsharings.controllers;

import antihype.carsharings.domain.Role;
import antihype.carsharings.domain.User;
import antihype.carsharings.repositories.UserRepository;
import antihype.carsharings.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserService service;

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDb = service.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.addAttribute("error", "User exists");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        service.saveUser(user);
        return "redirect:/login";
    }
}
