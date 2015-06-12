package cn.javis.giada.customer;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.javis.giada.customer.aspect.MessagePrinterManager;
import cn.javis.giada.customer.service.MessagePrinter;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class AppConfig {
    // @Bean
    // MessageService mockMessageService() {
    // return new MessageService() {
    // public String getMessage() {
    // return "Hello World!";
    // }
    // };
    // }

    // @Bean
    // MessagePrinterManager mockMessagePrinterManager() {
    // return new MessagePrinterManager();
    // }

    @Bean
    JndiObjectFactoryBean createJndiObjectFactoryBean() {
        JndiObjectFactoryBean jndiObjectFactoryBean =
                new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("/jdbc/javis");
        jndiObjectFactoryBean.setResourceRef(true);
        return jndiObjectFactoryBean;
    }

    @Bean
    JndiDataSourceLookup createJndiDataSourceLookup() {
        JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
        jndiDataSourceLookup.setResourceRef(true);
        return jndiDataSourceLookup;

    }

    @Bean
    AnnotationSessionFactoryBean createSessionFactory() {
        AnnotationSessionFactoryBean sessionFactory =
                new AnnotationSessionFactoryBean();
        sessionFactory.setDataSource(createJndiDataSourceLookup()
                .getDataSource("/jdbc/javis"));
        sessionFactory.setPackagesToScan("cn.javis.giada.customer");
        Properties prop = new Properties();
        prop.put("dialect", "org.hibernate.dialect.Oracle10gDialect");
        return sessionFactory;
    }

    @Bean
    HibernateTransactionManager createHibernateTransactionManager() {
        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();
        transactionManager
                .setSessionFactory((SessionFactory) createSessionFactory());
        return transactionManager;
    }

    @Bean
    PersistenceExceptionTranslationPostProcessor
            createPersistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        MessagePrinterManager manager =
                context.getBean(MessagePrinterManager.class);
        manager.listen();
        // ApplicationContext context = new
        // ClassPathXmlApplicationContext("applicationContext.xml");
        // MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }
}
