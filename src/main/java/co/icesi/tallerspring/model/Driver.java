package co.icesi.tallerspring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Driver implements Serializable {

    private String id;
    private String nombre;
    private String cargo;
    private int tipoIdentificacion;
    private String numIdentificacion;
    private List<Vehicle> vehicles = new ArrayList<>();

    public Driver() {}

    public Driver(String id, String nombre, String cargo, int tipoIdentificacion, String numIdentificacion) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numIdentificacion = numIdentificacion;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public int getTipoIdentificacion() { return tipoIdentificacion; }
    public void setTipoIdentificacion(int tipoIdentificacion) { this.tipoIdentificacion = tipoIdentificacion; }

    public String getNumIdentificacion() { return numIdentificacion; }
    public void setNumIdentificacion(String numIdentificacion) { this.numIdentificacion = numIdentificacion; }

    public List<Vehicle> getVehicles() { return vehicles; }
    public void setVehicles(List<Vehicle> vehicles) { this.vehicles = vehicles; }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
}
