package antihype.carsharings.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MySharesController {

    @GetMapping("/myshares")
    public String getPage(Model model) {
        return "myshares";
    }
}
