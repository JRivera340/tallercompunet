package co.icesi.tallerspring.controllers;



import co.icesi.tallerspring.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/listVehicles")
public class ListVehiclesController {

    @Autowired
    private VehicleServices vehicleService;

    @GetMapping
    public String listVehicles(Model model) {
        model.addAttribute("vehicles", vehicleService.getVehicles());
        return "listVehicles";
    }
}

