package cn.javis.apms.server.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:database.properties")
public class DatabaseConfig {
    @Autowired
    Environment env;

    @Bean(name = "dataSource")
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(env.getProperty("db.driver"));
        dataSource.setJdbcUrl(env.getProperty("db.url"));
        dataSource.setUser(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("c3p0.max_size")));
        dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("c3p0.min_size")));
        dataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("c3p0.max_idle_time")));
        dataSource.setMaxStatements(Integer.valueOf(env.getProperty("c3p0.max_statements")));
        return dataSource;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.scanPackages("cn.javis.apms.domain");
        sessionBuilder.addProperties(getHibernateProperties());
        return sessionBuilder.buildSessionFactory();
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.current_session_context_class",
                "org.springframework.orm.hibernate4.SpringSessionContext");
        properties.put("org.hibernate.flushMode", "COMMIT");
        String[] parameters = { "hibernate.show_sql", "hibernate.dialect", "hibernate.hbm2ddl.auto",
                "hibernate.jdbc.batch_size", "cache.provider_class", "hibernate.cache.use_second_level_cache" };
        for (int i = 0; i < parameters.length; i++) {
            String parameter = parameters[i];
            properties.put(parameter, env.getRequiredProperty(parameter));
        }
        return properties;
    }
}
