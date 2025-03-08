package co.icesi.tallerspring.controllers;



import co.icesi.tallerspring.model.Driver;
import co.icesi.tallerspring.services.DriverServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/searchDriverVehicles")
public class SearchDriverVehiclesController {

    @Autowired
    private DriverServices driverService;

    // Muestra el formulario
    @GetMapping
    public String showForm() {
        return "searchDriverVehicles";
    }

    // Procesa la búsqueda
    @PostMapping
    public String handleSearch(@RequestParam("numIdentificacion") String numIdentificacion, Model model) {
        try {
            Driver driver = driverService.findDriver(numIdentificacion);
            model.addAttribute("driver", driver);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "searchDriverVehicles";
    }
}
