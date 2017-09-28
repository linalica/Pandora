package by.itransition.pandora.configuration;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */
<<<<<<< HEAD
=======

import org.apache.commons.dbcp.BasicDataSource;
>>>>>>> new-start
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
<<<<<<< HEAD
import org.springframework.jdbc.datasource.DriverManagerDataSource;
=======
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
>>>>>>> new-start
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

<<<<<<< HEAD
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
/*@ImportResource("classpath:/product-servlet.xml")*/
=======
>>>>>>> new-start
@Configuration
@EnableTransactionManagement
@ComponentScan("by.itransition.pandora")
@EnableJpaRepositories("by.itransition.pandora.repository")
@PropertySource("classpath:properties/database.properties")
public class DataConfiguration {

<<<<<<< HEAD
    {
        //TODO: clean class from system.out.println()
        System.out.println("--- DataConfiguration -----!");
    }
=======
>>>>>>> new-start

    private static final String PROP_DATABASE_DRIVER = "db.driver";
    private static final String PROP_DATABASE_PASSWORD = "db.password";
    private static final String PROP_DATABASE_URL = "db.url";
    private static final String PROP_DATABASE_USERNAME = "db.username";

    private static final String PROP_HIBERNATE_DIALECT = "db.hibernate.dialect";
    private static final String PROP_HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
    private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = "db.entitymanager.packages.to.scan";
    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "db.hibernate.hbm2ddl.auto";

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
<<<<<<< HEAD

        System.out.println("--- dataSource -----");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
=======
        BasicDataSource dataSource = new BasicDataSource();
        //DriverManagerDataSource dataSource = new DriverManagerDataSource();
>>>>>>> new-start
        dataSource.setDriverClassName(env.getRequiredProperty(PROP_DATABASE_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(PROP_DATABASE_URL));
        dataSource.setUsername(env.getRequiredProperty(PROP_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROP_DATABASE_PASSWORD));
<<<<<<< HEAD
        System.out.println("--- dataSource END -----");
=======
>>>>>>> new-start
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
<<<<<<< HEAD
        System.out.println("--- entityManagerFactory -----");
=======
>>>>>>> new-start
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN));
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
<<<<<<< HEAD
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
        System.out.println("--- entityManagerFactory END");
=======
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());
>>>>>>> new-start
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
<<<<<<< HEAD
        System.out.println("--- transactionManager -----");
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        System.out.println("--- transactionManager END -----");
        return transactionManager;
    }

    private Properties getHibernateProperties() {
        System.out.println("--- getHibernateProperties -----");
=======
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    /*@Bean
    public CommonsMultipartResolver commonsMultipartResolver(){
        System.out.println("--- commonsMultipartResolver -----");
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("utf-8");
        commonsMultipartResolver.setMaxUploadSize(ControllerConstants.MAX_FILE_SIZE);
        System.out.println("--- commonsMultipartResolver END -----");
        return commonsMultipartResolver;
    }*/

    //<class dynamic-insert="true" dynamic-update="true" entity-name="Project" name="de.planta.server.hibernate.pojo.DynamicPojo" table="DT461">


    private Properties hibernateProperties() {
>>>>>>> new-start
        Properties properties = new Properties();
        properties.put(PROP_HIBERNATE_DIALECT, env.getRequiredProperty(PROP_HIBERNATE_DIALECT));
        properties.put(PROP_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROP_HIBERNATE_SHOW_SQL));
        properties.put(PROP_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROP_HIBERNATE_HBM2DDL_AUTO));
<<<<<<< HEAD
        System.out.println("--- getHibernateProperties END -----");
        return properties;
    }

=======
        return properties;
    }

    @Bean
    public JavaMailSender javaMailSender() {
        return new JavaMailSenderImpl();
    }
>>>>>>> new-start
}
