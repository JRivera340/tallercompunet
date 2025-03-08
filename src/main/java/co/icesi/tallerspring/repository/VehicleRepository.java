package co.icesi.tallerspring.repository;


import co.icesi.tallerspring.model.Vehicle;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {

    private List<Vehicle> vehicles = new ArrayList<>();

    // Obtener todos los vehículos
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicles);
    }

    // Buscar un vehículo por placa
    public Vehicle findVehicle(String placa) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlaca().equalsIgnoreCase(placa)) {
                return vehicle;
            }
        }
        return null;
    }

    // Nuevo método: Buscar un vehículo por ID
    public Vehicle findVehicleById(String id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equalsIgnoreCase(id)) {
                return vehicle;
            }
        }
        return null;
    }

    // Agregar un vehículo
    public void save(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    // Eliminar un vehículo
    public void delete(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public boolean existByPlaca(String placa) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlaca().equalsIgnoreCase(placa)) {
                return true;
            }
        }
        return false;
    }
}
