package co.icesi.tallerspring.services;


import co.icesi.tallerspring.model.Driver;
import co.icesi.tallerspring.model.Vehicle;
import co.icesi.tallerspring.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleServices {

    private final VehicleRepository vehicleRepository;
    private final DriverServices driverService;

    @Autowired
    public VehicleServices(VehicleRepository vehicleRepository, DriverServices driverService) {
        this.vehicleRepository = vehicleRepository;
        this.driverService = driverService;
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.getAllVehicles();
    }

    public Vehicle getVehicle(String placa) {
        return vehicleRepository.findVehicle(placa);
    }

    // Método existente (alias de getVehicle)
    public Vehicle searchVehicle(String placa) {
        return getVehicle(placa);
    }

    // NUEVO: Buscar vehículo por ID
    public Vehicle searchVehicleById(String id) {
        return vehicleRepository.findVehicleById(id);
    }

    public void addVehicleToDriver(Vehicle vehicle, String id) {
        if (vehicleRepository.existByPlaca(vehicle.getPlaca())) {
            throw new IllegalArgumentException("Ya existe un vehículo con la placa: " + vehicle.getPlaca());
        }
        Driver driver = driverService.findDriver(id);
        if (driver == null) {
            throw new IllegalArgumentException("No se encontró un conductor con el ID: " + id);
        }
        driver.addVehicle(vehicle);
        vehicleRepository.save(vehicle);
        System.out.println("Vehículo agregado exitosamente al conductor: " + driver.getNombre());
    }

    public void deleteVehicleByPlaca(String placa) {
        Vehicle vehicle = vehicleRepository.findVehicle(placa);
        if (vehicle == null) {
            throw new IllegalArgumentException("No existe un vehículo con la placa: " + placa);
        }
        vehicleRepository.delete(vehicle);
        System.out.println("Se ha eliminado el vehículo con placa: " + placa);
    }
}
