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

@WebServlet("/searchDriverVehicles")
public class SearchDriverVehiclesServlet extends HttpServlet {

    @Autowired
    private DriverServices driverService;

    @Override
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numIdentificacion = request.getParameter("numIdentificacion");
        Driver driver = driverService.findDriver(numIdentificacion);
        request.setAttribute("driver", driver);
        request.getRequestDispatcher("WEB-INF/views/searchDriverVehicles.jsp").forward(request, response);
    }
}
