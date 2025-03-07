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
import java.util.List;

@WebServlet("/listDrivers")
public class ListDriversServlet extends HttpServlet {

    @Autowired
    private DriverServices driverService;

    @Override
    public void init() throws ServletException {
        // Permite a Spring inyectar las dependencias en este servlet
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Driver> drivers = driverService.findAllDrivers();
        request.setAttribute("drivers", drivers);
        request.getRequestDispatcher("WEB-INF/views/listDrivers.jsp").forward(request, response);
    }
}
