package co.icesi.tallerspring.servlets;

import co.icesi.tallerspring.model.Driver;
import co.icesi.tallerspring.services.DriverServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet para listar todos los conductores con sus vehículos
 */
@WebServlet("/listDrivers")
public class ListDriversServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DriverServices driverService = (DriverServices) getServletContext().getAttribute("driverService");
        List<Driver> drivers = driverService.findAllDrivers();
        request.setAttribute("drivers", drivers);
        request.getRequestDispatcher("WEB-INF/views/listDrivers.jsp").forward(request, response);
    }
}
