package co.icesi.tallerspring.servlets;


import co.icesi.tallerspring.model.Driver;
import co.icesi.tallerspring.services.DriverServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;

@WebServlet("/addDriver")
public class AddDriverServlet extends HttpServlet {

    @Autowired
    private DriverServices driverService;

    @Override
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Muestra el formulario
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

        try {
            // Creamos el objeto Driver
            Driver driver = new Driver(id, name, cargo, tipoIdentificacion, numIdentificacion);
            // Llamamos al servicio para crear
            driverService.createDriver(driver);

            // Si todo va bien, asignamos mensaje de éxito
            request.setAttribute("successMessage", "Conductor '" + name + "' agregado exitosamente.");
        } catch (IllegalArgumentException e) {

            request.setAttribute("errorMessage", e.getMessage());
        }


        request.getRequestDispatcher("/WEB-INF/views/addDriver.jsp").forward(request, response);
    }
}
