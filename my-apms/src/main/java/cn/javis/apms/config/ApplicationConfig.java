package cn.javis.apms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:appliation.properties")
public class ApplicationConfig {

    @Autowired
    private static Environment env;

//    public static final String DATE_FORMAT = env.getProperty("date_format");

}
