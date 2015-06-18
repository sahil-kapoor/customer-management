package cn.javis.apms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "cn.javis.apms" })
@EnableTransactionManagement
@Import(DatabaseConfig.class)
public class WebAppConfig extends WebMvcConfigurerAdapter {

//    @Autowired
//    private ApplicationContext appCtx;
//
//    @Autowired
//    @Bean(name = "objectMapper")
//    public ObjectMapper applicationContextAwareObjectMapper(ApplicationContext applicationContext) {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setDateFormat(new SimpleDateFormat("yyyy/MM/dd"));
//        mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
//        mapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        mapper.setHandlerInstantiator(new SpringBeanHandlerInstantiator(applicationContext));
//        // Guava
////        mapper.registerModule(new GuavaModule());
//        //Hibernate4
//        Hibernate4Module h4m = new Hibernate4Module();
//        h4m.enable(Hibernate4Module.Feature.FORCE_LAZY_LOADING);
//        h4m.enable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION);
//        mapper.registerModule(h4m);
//        //jdk8 
//        mapper.registerModule(new Jdk8Module());
//
//        return mapper;
//    }
//
//    @Autowired
//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(ObjectMapper objectMapper) {
//        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
//        messageConverter.setObjectMapper(objectMapper);
//        return messageConverter;
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
//        stringConverter.setWriteAcceptCharset(false);
//        converters.add(new ByteArrayHttpMessageConverter());
//        converters.add(stringConverter);
//        converters.add(new ResourceHttpMessageConverter());
//        converters.add(new SourceHttpMessageConverter<Source>());
//        converters.add(new AllEncompassingFormHttpMessageConverter());
//        converters.add(appCtx.getBean("mappingJackson2HttpMessageConverter", MappingJackson2HttpMessageConverter.class));
//    }
}
