package co.icesi.tallerspring.controllers;



import co.icesi.tallerspring.model.Vehicle;
import co.icesi.tallerspring.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/searchVehicleById")
public class SearchVehicleByIdController {

    @Autowired
    private VehicleServices vehicleServices;

    // Muestra el formulario
    @GetMapping
    public String showForm() {
        return "searchVehicleById";
    }

    // Procesa la búsqueda
    @PostMapping
    public String handleSearch(@RequestParam("vehicleId") String vehicleId, Model model) {
        Vehicle vehicle = vehicleServices.searchVehicleById(vehicleId);
        if (vehicle == null) {
            model.addAttribute("errorMessage", "No se encontró vehículo con el ID: " + vehicleId);
        } else {
            model.addAttribute("vehicle", vehicle);
        }
        return "searchVehicleById";
    }
}
