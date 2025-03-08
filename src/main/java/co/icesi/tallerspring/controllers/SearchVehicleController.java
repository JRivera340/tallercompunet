package co.icesi.tallerspring.controllers;



import co.icesi.tallerspring.model.Vehicle;
import co.icesi.tallerspring.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/searchVehicle")
public class SearchVehicleController {

    @Autowired
    private VehicleServices vehicleService;

    // Muestra el formulario
    @GetMapping
    public String showForm() {
        return "searchVehicle";
    }

    // Procesa la búsqueda
    @PostMapping
    public String handleSearch(@RequestParam("placa") String placa, Model model) {
        Vehicle vehicle = vehicleService.getVehicle(placa);
        if (vehicle == null) {
            model.addAttribute("errorMessage", "No se encontró vehículo con la placa: " + placa);
        } else {
            model.addAttribute("vehicle", vehicle);
        }
        return "searchVehicle";
    }
}
