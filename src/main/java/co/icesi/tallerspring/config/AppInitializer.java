package co.icesi.tallerspring.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Configuración raíz, donde incluyes AppConfig
        return new Class<?>[] { AppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Si quisieras separar la config web de la config root,
        // podrías retornar una clase distinta. Por simplicidad, null.
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        // Mapea el DispatcherServlet a "/"
        return new String[] { "/" };
    }
}
