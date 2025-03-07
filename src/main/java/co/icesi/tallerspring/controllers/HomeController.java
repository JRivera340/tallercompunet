package co.icesi.tallerspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/index.jsp");
        modelAndView.addObject("message", "Bienvenido a Taller Spring con Jakarta EE 9+ y Tomcat 10.1.35");
        return modelAndView;
    }
}
