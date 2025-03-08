package co.icesi.tallerspring.controllers;



import co.icesi.tallerspring.model.Driver;
import co.icesi.tallerspring.services.DriverServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/addDriver")
public class AddDriverController {

    @Autowired
    private DriverServices driverService;

    // Muestra el formulario (equivalente a doGet)
    @GetMapping
    public String showAddDriverForm() {
        // Retorna el nombre de la vista JSP (sin .jsp),
        // Spring usará /WEB-INF/views/addDriver.jsp
        return "addDriver";
    }

    // Procesa el formulario (equivalente a doPost)
    @PostMapping
    public String handleAddDriver(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("cargo") String cargo,
            @RequestParam("tipoIdentificacion") int tipoIdentificacion,
            @RequestParam("numIdentificacion") String numIdentificacion,
            Model model
    ) {
        try {
            Driver driver = new Driver(id, name, cargo, tipoIdentificacion, numIdentificacion);
            driverService.createDriver(driver);
            model.addAttribute("successMessage", "Conductor '" + name + "' agregado exitosamente.");
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "addDriver";  // Muestra la misma página con el mensaje
    }
}
