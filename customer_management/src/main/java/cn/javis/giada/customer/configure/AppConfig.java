package cn.javis.giada.customer.configure;


//@Configuration
//@ComponentScan
//@EnableAspectJAutoProxy
//@EnableTransactionManagement
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

    // Setup database connection
    // @Bean
    // BasicDataSource dataSource() {
    // BasicDataSource dataSource = new BasicDataSource();
    // dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    // dataSource.setUrl("jdbc:mysql://localhost:1433/javis");
    // dataSource.setUsername("javis");
    // dataSource.setPassword("yan19881019");
    // dataSource.setInitialSize(5);
    // return dataSource;
    // }

    // @Bean
    // JndiObjectFactoryBean jndiObjectFactoryBean() {
    // JndiObjectFactoryBean jndiObjectFactoryBean = new
    // JndiObjectFactoryBean();
    // jndiObjectFactoryBean.setJndiName("/jdbc/javis");
    // jndiObjectFactoryBean.setResourceRef(true);
    // return jndiObjectFactoryBean;
    // }
    //
    // @Bean
    // JndiDataSourceLookup jndiDataSourceLookup() {
    // JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
    // jndiDataSourceLookup.setResourceRef(true);
    // return jndiDataSourceLookup;
    //
    // }



    // @Bean
    // AnnotationSessionFactoryBean sessionFactory() {
    // AnnotationSessionFactoryBean sessionFactory = new
    // AnnotationSessionFactoryBean();
    // sessionFactory.setDataSource(dataSource());
    // sessionFactory.setPackagesToScan("cn.javis.giada.customer");
    // Properties prop = new Properties();
    // prop.put("dialect", "org.hibernate.dialect.MySQL5Dialect");
    // return sessionFactory;
    // }

    // @Bean
    // HibernateTransactionManager hibernateTransactionManager() {
    // HibernateTransactionManager transactionManager = new
    // HibernateTransactionManager();
    // transactionManager.setSessionFactory((SessionFactory) sessionFactory());
    // return transactionManager;
    // }

    // @Bean
    // PersistenceExceptionTranslationPostProcessor
    // createPersistenceExceptionTranslationPostProcessor() {
    // return new PersistenceExceptionTranslationPostProcessor();
    // }

    // public static void main(String[] args) {
    // ApplicationContext context = new
    // AnnotationConfigApplicationContext(AppConfig.class);
    // MessagePrinter printer = context.getBean(MessagePrinter.class);
    // MessagePrinterManager manager =
    // context.getBean(MessagePrinterManager.class);
    // manager.listen();
    // // ApplicationContext context = new
    // // ClassPathXmlApplicationContext("applicationContext.xml");
    // // MessagePrinter printer = context.getBean(MessagePrinter.class);
    // printer.printMessage();
    // }
}
