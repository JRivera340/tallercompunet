package co.icesi.tallerspring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.ViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "co.icesi.tallerspring")
public class AppConfig {

    // Configura dónde buscar las vistas JSP
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    // Define beans manuales si no usas @Repository/@Service
    // o si deseas forzar la creación de ciertos beans:
    @Bean
    public co.icesi.tallerspring.repository.DriverRepository driverRepository() {
        return new co.icesi.tallerspring.repository.DriverRepository();
    }

    @Bean
    public co.icesi.tallerspring.repository.VehicleRepository vehicleRepository() {
        return new co.icesi.tallerspring.repository.VehicleRepository();
    }

    @Bean
    public co.icesi.tallerspring.services.DriverServices driverServices(
            co.icesi.tallerspring.repository.DriverRepository driverRepository) {
        return new co.icesi.tallerspring.services.DriverServices(driverRepository);
    }

    @Bean
    public co.icesi.tallerspring.services.VehicleServices vehicleServices(
            co.icesi.tallerspring.repository.VehicleRepository vehicleRepository,
            co.icesi.tallerspring.services.DriverServices driverServices) {
        return new co.icesi.tallerspring.services.VehicleServices(vehicleRepository, driverServices);
    }
}
