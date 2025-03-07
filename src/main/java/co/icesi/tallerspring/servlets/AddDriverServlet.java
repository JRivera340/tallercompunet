package co.icesi.tallerspring.servlets;

import co.icesi.tallerspring.model.Driver;
import co.icesi.tallerspring.services.DriverServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Servlet para agregar un conductor
 */
@WebServlet("/addDriver")
public class AddDriverServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/addDriver.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String cargo = request.getParameter("cargo");
        int tipoIdentificacion = Integer.parseInt(request.getParameter("tipoIdentificacion"));
        String numIdentificacion = request.getParameter("numIdentificacion");

        Driver driver = new Driver(id, name, cargo, tipoIdentificacion, numIdentificacion);
        DriverServices driverService = (DriverServices) getServletContext().getAttribute("driverService");
        driverService.createDriver(driver);

        response.sendRedirect("listDrivers");
    }
}
