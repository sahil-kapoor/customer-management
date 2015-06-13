package cn.javis.giada.customer.configure;

import javax.naming.NamingException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import cn.javis.giada.customer.dao.CustomerQueryDao;
import cn.javis.giada.customer.service.CustomerServiceImpl;
import cn.javis.giada.customer.service.interfaces.CustomerService;

@Configuration
// @ComponentScan(basePackages = "cn.javis.giada.customer.controller")
// @EnableAspectJAutoProxy
// @EnableTransactionManagement
public class JndiDataConfig {
    @Bean
    BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/javis");
        dataSource.setUsername("javis");
        dataSource.setPassword("yan19881019");
        dataSource.setInitialSize(5);
        return dataSource;
    }

    // @Bean
    // public DataSource dataSource() throws NamingException {
    // Context ctx = new InitialContext();
    // return (DataSource) ctx.lookup("java:comp/env/jdbc/javis");
    // }

    @Bean
    NamedParameterJdbcTemplate jdbcTemplate() throws NamingException {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    @Bean
    CustomerService customerService() {
        return new CustomerServiceImpl();
    }

    @Bean
    CustomerQueryDao customerQueryDao() {
        return new CustomerQueryDao();
    }
}
