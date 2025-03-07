package co.icesi.tallerspring.servlets;

import co.icesi.tallerspring.services.VehicleServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import java.io.IOException;

/**
 * Servlet para listar vehículos
 */
@WebServlet("/listVehicles")
public class ListVehiclesServlet extends HttpServlet {

    private VehicleServices vehicleService;

    @Override
    public void init() {
        // Obtener el contexto de Spring y obtener el servicio de vehículos
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        this.vehicleService = context.getBean(VehicleServices.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("vehicles", vehicleService.getVehicles());
        request.getRequestDispatcher("/WEB-INF/views/listVehicles.jsp").forward(request, response);
    }
}
