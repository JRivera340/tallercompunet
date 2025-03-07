package co.icesi.tallerspring.servlets;

import co.icesi.tallerspring.model.Driver;
import co.icesi.tallerspring.services.DriverServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet para buscar los vehículos de un conductor
 */
@WebServlet("/searchDriverVehicles")
public class SearchDriverVehiclesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numIdentificacion = request.getParameter("numIdentificacion");
        DriverServices driverService = (DriverServices) getServletContext().getAttribute("driverService");
        Driver driver = driverService.findDriver(numIdentificacion);
        request.setAttribute("driver", driver);
        request.getRequestDispatcher("WEB-INF/views/searchDriverVehicles.jsp").forward(request, response);
    }
}
