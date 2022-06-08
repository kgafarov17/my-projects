package az.edu.ada.wm2.simple_spring_boot_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController{

    @GetMapping("")
    public String getHome(){
        return "home";
    }


}
