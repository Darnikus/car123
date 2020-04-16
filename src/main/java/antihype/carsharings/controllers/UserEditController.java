package antihype.carsharings.controllers;

import antihype.carsharings.domain.User;
import antihype.carsharings.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "user")
public class UserEditController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        return "useredit";
    }

    @PostMapping
    public String userUpdate(
            @RequestParam String username,
            @RequestParam("userId") User user
    ) {
        user.setUsername(username);

        service.saveUser(user);

        return "redirect:/home";
    }
}
