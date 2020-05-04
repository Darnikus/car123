package antihype.carsharings.controllers;

import antihype.carsharings.domain.User;
import antihype.carsharings.repositories.UserRepository;
import antihype.carsharings.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "account")
public class UserEditController {
    private UserService service;
    private UserRepository repository;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping("/edit")
    public String userEditForm(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "useredit";
    }


    @PostMapping("/edit")
    public String userUpdate(
            @RequestParam String username,
            @AuthenticationPrincipal User user,
            Model model
    ) {
        user.setUsername(username);
        service.saveUser(user);
        return "redirect:/account";
    }

    @GetMapping("/password_edit")
    public String passwordEditForm(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "password_edit";
    }

    // it's not working
    @PostMapping("/password_edit")
    public String passwordUpdate(
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword,
            @AuthenticationPrincipal User user,
            Model model
    ) {

        if(password.equals(confirmPassword)) {
            user.setPassword(password);
            return "redirect:/logout";
        } else {
            model.addAttribute("error", "error");
            return "password_edit";
        }
    }
}
