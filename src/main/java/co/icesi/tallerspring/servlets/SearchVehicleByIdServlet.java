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

@WebServlet("/searchVehicleById")
public class SearchVehicleByIdServlet extends HttpServlet {

    @Autowired
    private VehicleServices vehicleServices;

    @Override
    public void init() throws ServletException {
        // Permite que Spring inyecte las dependencias en este servlet.
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    // Permite que el formulario se muestre al invocar GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/searchVehicleById.jsp")
                .forward(request, response);
    }

    // Procesa la búsqueda usando POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vehicleId = request.getParameter("vehicleId");
        Vehicle vehicle = vehicleServices.searchVehicleById(vehicleId);
        request.setAttribute("vehicle", vehicle);
        request.getRequestDispatcher("/WEB-INF/views/searchVehicleById.jsp")
                .forward(request, response);
    }
}
