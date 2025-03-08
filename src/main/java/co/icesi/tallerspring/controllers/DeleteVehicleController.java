package co.icesi.tallerspring.controllers;



import co.icesi.tallerspring.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/deleteVehicle")
public class DeleteVehicleController {

    @Autowired
    private VehicleServices vehicleServices;

    // Muestra el formulario
    @GetMapping
    public String showDeleteVehicleForm() {
        return "deleteVehicle";
    }

    // Procesa la eliminación
    @PostMapping
    public String handleDeleteVehicle(@RequestParam("placa") String placa, Model model) {
        try {
            vehicleServices.deleteVehicleByPlaca(placa);
            model.addAttribute("successMessage", "Vehículo con placa '" + placa + "' eliminado exitosamente.");
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "deleteVehicle";
    }
}
