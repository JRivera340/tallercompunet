package co.icesi.tallerspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index"); // Resolverá a /WEB-INF/views/index.jsp
        mv.addObject("message", "Bienvenido a Taller Spring con Jakarta EE 9+ y Tomcat 10.1.35");
        return mv;
    }
}
