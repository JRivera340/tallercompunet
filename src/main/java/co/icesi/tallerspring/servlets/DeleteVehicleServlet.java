package co.icesi.tallerspring.servlets;

import co.icesi.tallerspring.services.VehicleServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import java.io.IOException;

@WebServlet("/deleteVehicle")
public class DeleteVehicleServlet extends HttpServlet {

    @Autowired
    private VehicleServices vehicleService;

    @Override
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String placa = request.getParameter("placa");
        vehicleService.deleteVehicleByPlaca(placa);
        response.sendRedirect("listVehicles");
    }
}
