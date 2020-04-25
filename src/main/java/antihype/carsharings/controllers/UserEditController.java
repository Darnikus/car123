package antihype.carsharings.controllers;

import antihype.carsharings.domain.User;
import antihype.carsharings.repositories.UserRepository;
import antihype.carsharings.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "user")
public class UserEditController {
    private UserService service;
    private UserRepository repository;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("{user}")
    public String userEditForm(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "useredit";
    }



    @PostMapping("{user}")
    public String userUpdate(
            @RequestParam String username,
            @PathVariable("id") Long id,
            @Valid User user,
            Model model
    ) {
//        Optional<User> user = repository.findById(id);
////        user.get().setUsername(username);
//        User present = user.get();
//        User user = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid"));


        user.setUsername(username);

        service.saveUser(user);

        return "redirect:/home";
    }
}
