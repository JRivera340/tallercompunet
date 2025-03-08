package co.icesi.tallerspring.controllers;



import co.icesi.tallerspring.model.Driver;
import co.icesi.tallerspring.services.DriverServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/listDrivers")
public class ListDriversController {

    @Autowired
    private DriverServices driverService;

    // Equivalente a doGet: lista conductores
    @GetMapping
    public String listDrivers(Model model) {
        List<Driver> drivers = driverService.findAllDrivers();
        model.addAttribute("drivers", drivers);
        return "listDrivers"; // JSP: /WEB-INF/views/listDrivers.jsp
    }
}
