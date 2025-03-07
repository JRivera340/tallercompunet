package co.icesi.tallerspring.repository;

import co.icesi.tallerspring.model.Vehicle;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio para gestionar vehículos
 */
@Repository
public class VehicleRepository {

    private final List<Vehicle> vehicles = new ArrayList<>();

    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicles);
    }

    public Vehicle findVehicle(String placa) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
    }

    public void save(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void delete(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public boolean existByPlaca(String placa) {
        return vehicles.stream().anyMatch(vehicle -> vehicle.getPlaca().equalsIgnoreCase(placa));
    }
}
