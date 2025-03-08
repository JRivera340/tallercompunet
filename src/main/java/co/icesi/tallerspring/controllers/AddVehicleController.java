package co.icesi.tallerspring.controllers;



import co.icesi.tallerspring.model.Vehicle;
import co.icesi.tallerspring.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/addVehicle")
public class AddVehicleController {

    @Autowired
    private VehicleServices vehicleService;

    // Muestra el formulario
    @GetMapping
    public String showAddVehicleForm() {
        return "addVehicle";
    }

    // Procesa el formulario
    @PostMapping
    public String handleAddVehicle(
            @RequestParam("id") String id,
            @RequestParam("placa") String placa,
            @RequestParam("cilindraje") String cilindraje,
            @RequestParam("tipoCombustible") String tipoCombustible,
            @RequestParam("numeroMotor") String numeroMotor,
            @RequestParam("marca") String marca,
            @RequestParam("modelo") int modelo,
            @RequestParam("conductorId") String conductorId,
            Model model
    ) {
        try {
            Vehicle vehicle = new Vehicle(id, placa, cilindraje, tipoCombustible, numeroMotor, marca, modelo);
            vehicleService.addVehicleToDriver(vehicle, conductorId);
            model.addAttribute("successMessage", "Vehículo con placa '" + placa + "' agregado exitosamente.");
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "addVehicle";
    }
}

