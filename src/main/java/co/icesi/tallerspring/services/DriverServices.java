package co.icesi.tallerspring.services;

import co.icesi.tallerspring.model.Driver;
import co.icesi.tallerspring.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverServices {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverServices(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> findAllDrivers() {
        return driverRepository.getDrivers();
    }

    public void createDriver(Driver driver) {
        driverRepository.save(driver);
        System.out.println("Conductor guardado: " + driver.getNombre() + " con ID: " + driver.getId());
    }

    public Driver findDriver(String numId) {
        Driver driver = driverRepository.findDriver(numId);
        if (driver == null) {
            throw new IllegalArgumentException("No se encontró un conductor con ID: " + numId);
        }
        return driver;
    }
}
