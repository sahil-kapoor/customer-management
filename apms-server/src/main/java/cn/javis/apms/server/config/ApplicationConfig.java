package cn.javis.apms.server.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:appliation.properties")
public class ApplicationConfig {

//    @Autowired
//    private static Environment env;

//    public static final String DATE_FORMAT = env.getProperty("date_format");

}
