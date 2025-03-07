package co.icesi.tallerspring.repository;

import co.icesi.tallerspring.model.Driver;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio para gestionar conductores
 */
@Repository
public class DriverRepository {

    private final List<Driver> drivers = new ArrayList<>();

    public List<Driver> getDrivers() {
        return new ArrayList<>(drivers);
    }

    public void save(Driver driver) {
        drivers.add(driver);
    }

    public Driver findDriver(String numId) {
        return drivers.stream()
                .filter(driver -> driver.getNumIdentificacion().equals(numId))
                .findFirst()
                .orElse(null);
    }

    public boolean exists(Driver driver) {
        return drivers.contains(driver);
    }
}
