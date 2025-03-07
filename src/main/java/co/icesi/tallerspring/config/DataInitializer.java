package co.icesi.tallerspring.config;

import co.icesi.tallerspring.model.Driver;
import co.icesi.tallerspring.model.Vehicle;
import co.icesi.tallerspring.services.DriverServices;
import co.icesi.tallerspring.services.VehicleServices;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final DriverServices driverService;
    private final VehicleServices vehicleService;

    public DataInitializer(DriverServices driverService, VehicleServices vehicleService) {
        this.driverService = driverService;
        this.vehicleService = vehicleService;
    }

    @PostConstruct
    public void init() {
        System.out.println("=== Cargando datos iniciales en Spring ===");

        // ✅ Primero, creamos y guardamos los conductores
        Driver driver1 = new Driver("01", "Juan Amor", "Profesor", 1, "114382811");
        Driver driver2 = new Driver("02", "Joshua Rivera", "Monitor", 2, "114629291");
        Driver driver3 = new Driver("03", "Joseph Velez", "Estudiante", 1, "11202392");

        driverService.createDriver(driver1);
        driverService.createDriver(driver2);
        driverService.createDriver(driver3);

        // ✅ Luego, confirmamos que los conductores fueron guardados
        System.out.println("Conductores guardados en la base de datos:");
        driverService.findAllDrivers().forEach(driver -> System.out.println("- " + driver.getNombre()));

        // ✅ Ahora sí, creamos y asignamos los vehículos a los conductores ya existentes
        Vehicle vehicle1 = new Vehicle("V001", "ABC123", "1600", "Gasolina", "MOTORA123B12", "Toyota", 2021);
        Vehicle vehicle2 = new Vehicle("V002", "BCD234", "2000", "Gasolina", "MOTORB123C34", "Mazda", 2020);
        Vehicle vehicle3 = new Vehicle("V003", "CDE345", "1800", "Gasolina", "MOTORC123D56", "Nissan", 2019);

        // 🚀 Ahora sí podemos agregar vehículos sin errores
        try {
            vehicleService.addVehicleToDriver(vehicle1, "01");
            vehicleService.addVehicleToDriver(vehicle2, "02");
            vehicleService.addVehicleToDriver(vehicle3, "03");
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Error al asignar vehículos: " + e.getMessage());
        }

        System.out.println("=== Datos cargados correctamente ===");
    }
}
