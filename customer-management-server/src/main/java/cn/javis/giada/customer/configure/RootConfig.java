package cn.javis.giada.customer.configure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
//(basePackages = { "cn.javis.giada.customer" }, excludeFilters = { @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
public class RootConfig {

}
