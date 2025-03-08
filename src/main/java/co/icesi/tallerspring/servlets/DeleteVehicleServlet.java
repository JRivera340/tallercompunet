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
    private VehicleServices vehicleServices;

    @Override
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String placa = request.getParameter("placa");

        try {
            // Llamamos al servicio para eliminar
            vehicleServices.deleteVehicleByPlaca(placa);
            // Si no lanza excepción, es éxito
            request.setAttribute("successMessage", "Vehículo con placa '" + placa + "' eliminado exitosamente.");
        } catch (IllegalArgumentException e) {
            // Capturamos la excepción lanzada si no existe el vehículo
            request.setAttribute("errorMessage", e.getMessage());
        }

        // Volvemos al mismo JSP con el mensaje
        request.getRequestDispatcher("deleteVehicle.jsp").forward(request, response);
    }

    // Si también quieres permitir doGet (por si el usuario abre /deleteVehicle directo)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Simplemente mostramos el JSP (formulario)
        request.getRequestDispatcher("deleteVehicle.jsp").forward(request, response);
    }
}
