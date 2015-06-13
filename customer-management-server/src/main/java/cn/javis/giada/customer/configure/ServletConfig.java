package cn.javis.giada.customer.configure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAspectJAutoProxy
@EnableWebMvc
@ComponentScan("cn.javis.giada.customer")
public class ServletConfig extends WebMvcConfigurerAdapter {
	// @Override
	// public void configureDefaultServletHandling(
	// DefaultServletHandlerConfigurer configurer) {
	// configurer.enable();
	// }

	// @Bean
	// public ViewResolver cnViewResolver() {
	// return new ContentNegotiatingViewResolver();
	// }

//	@Override
//	public void configureContentNegotiation(
//			ContentNegotiationConfigurer configurer) {
//		configurer.defaultContentType(MediaType.APPLICATION_JSON);
//	}

}
