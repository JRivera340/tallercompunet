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
 * Servlet para buscar un vehículo por su placa
 */
@WebServlet("/searchVehicle")
public class SearchVehicleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String placa = request.getParameter("placa");
        VehicleServices vehicleService = (VehicleServices) getServletContext().getAttribute("vehicleService");
        Vehicle vehicle = vehicleService.getVehicle(placa);
        request.setAttribute("vehicle", vehicle);
        request.getRequestDispatcher("WEB-INF/views/searchVehicle.jsp").forward(request, response);
    }
}
