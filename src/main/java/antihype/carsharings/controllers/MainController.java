package antihype.carsharings.controllers;

import antihype.carsharings.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model) {
        return "main";
    }

//    @GetMapping("/home")
//    public String home(Model model) {
//        return "home";
//    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }


    @GetMapping("/account")
    public String account(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "account";
    }
}
