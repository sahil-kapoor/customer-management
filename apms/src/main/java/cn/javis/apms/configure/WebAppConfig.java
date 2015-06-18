package cn.javis.apms.configure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages= "cn.javis.apms")
//@EnableWebMvc
@EnableAspectJAutoProxy
//@Import(DatabaseConfig.class)
public class WebAppConfig /*extends WebMvcConfigurerAdapter*/{

}
