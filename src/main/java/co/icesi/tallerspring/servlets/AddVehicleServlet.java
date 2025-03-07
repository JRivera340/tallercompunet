package co.icesi.tallerspring.servlets;

import co.icesi.tallerspring.model.Vehicle;
import co.icesi.tallerspring.services.VehicleServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import java.io.IOException;

@WebServlet("/addVehicle")
public class AddVehicleServlet extends HttpServlet {

    @Autowired
    private VehicleServices vehicleService;

    @Override
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String placa = request.getParameter("placa");
        String cilindraje = request.getParameter("cilindraje");
        String tipoCombustible = request.getParameter("tipoCombustible");
        String numeroMotor = request.getParameter("numeroMotor");
        String marca = request.getParameter("marca");
        int modelo = Integer.parseInt(request.getParameter("modelo"));
        String conductorId = request.getParameter("conductorId");

        Vehicle vehicle = new Vehicle(id, placa, cilindraje, tipoCombustible, numeroMotor, marca, modelo);
        vehicleService.addVehicleToDriver(vehicle, conductorId);
        response.sendRedirect("listDrivers");
    }
}
