package wm2.as3.login_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController{

    Logger logger = LoggerFactory.getLogger(CountryController.class);

    @GetMapping("")
    public String getHome(){
        logger.info("Welcome to Country Spring Boot App!");

        return "home";
    }


}
