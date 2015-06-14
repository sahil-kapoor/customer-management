package cn.javis.giada.customer.configure;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitailizer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {
        super.onStartup(servletContext);
        // servletContext.addListener(new SessionListener());
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { ServletConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}
