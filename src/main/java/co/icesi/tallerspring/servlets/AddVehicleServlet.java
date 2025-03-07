package co.icesi.tallerspring.servlets;

import co.icesi.tallerspring.model.Vehicle;
import co.icesi.tallerspring.services.VehicleServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet para agregar un vehículo a un conductor
 */
@WebServlet("/addVehicle")
public class AddVehicleServlet extends HttpServlet {
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
        VehicleServices vehicleService = (VehicleServices) getServletContext().getAttribute("vehicleService");
        vehicleService.addVehicleToDriver(vehicle, conductorId);
        response.sendRedirect("listDrivers");
    }
}
