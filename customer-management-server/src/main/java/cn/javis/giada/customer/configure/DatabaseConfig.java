package cn.javis.giada.customer.configure;

import javax.naming.NamingException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
@PropertySource("classpath:config.properties")
// @EnableTransactionManagement
public class DatabaseConfig {
    @Autowired
    Environment env;

    @Bean
    BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        // dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        // dataSource.setUrl("jdbc:mysql://localhost:3306/javis");
        // dataSource.setUsername("javis");
        // dataSource.setPassword("yan19881019");
        // dataSource.setInitialSize(5);
        System.out.println(env.getProperty("jdbc.driverClassName"));
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setInitialSize(env.getProperty("jdbc.initialsize",
                Integer.class));
        return dataSource;
    }

    // @Bean
    // public DataSource dataSource() throws NamingException {
    // Context ctx = new InitialContext();
    // return (DataSource) ctx.lookup("java:comp/env/jdbc/javis");
    // }

    @Bean
    NamedParameterJdbcTemplate jdbcTemplate() throws NamingException {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(
                dataSource());
        return jdbcTemplate;
    }

    // @Bean
    // CustomerService customerService() {
    // return new CustomerServiceImpl();
    // }

    // @Bean
    // CustomerQueryDao customerQueryDao() {
    // return new CustomerQueryDao();
    // }
}
