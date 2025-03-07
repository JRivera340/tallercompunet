package co.icesi.tallerspring.config;

import co.icesi.tallerspring.repository.DriverRepository;
import co.icesi.tallerspring.repository.VehicleRepository;
import co.icesi.tallerspring.services.DriverServices;
import co.icesi.tallerspring.services.VehicleServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "co.icesi.tallerspring")
public class AppConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public DriverRepository driverRepository() {
        return new DriverRepository();
    }

    @Bean
    public VehicleRepository vehicleRepository() {
        return new VehicleRepository();
    }

    @Bean
    public DriverServices driverServices(DriverRepository driverRepository) {
        return new DriverServices(driverRepository);
    }

    @Bean
    public VehicleServices vehicleServices(VehicleRepository vehicleRepository, DriverServices driverServices) {
        return new VehicleServices(vehicleRepository, driverServices);
    }


}
