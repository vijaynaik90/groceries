package com.iyengarcoders.groceries.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.iyengarcoders.groceries")
@PropertySource(value = { "classpath:application.properties", "classpath:application.yml" })
public class GroceryConfig implements WebMvcConfigurer {


    @Autowired
    private Environment env;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hibernatehbm2ddl;
//
//    @Value("${spring.jpa.properties.hibernate.dialect}")
//    private String hibernateDialect;
//
//    @Value("${spring.jpa.properties.hibernate.show_sql}")
//    private String showSql;
//
//    @Value("${spring.jpa.properties.hibernate.use_sql_comments}")
//    private String useSqlComments;
//    @Value("${spring.jpa.properties.hibernate.format_sql}")
//    private String formatSql;

//    @Value("${hibernate.search.default.indexBase}")
//    private String hibernateIndexBase;

    @Bean
    public DataSource dataSource(){

        HikariDataSource dataSource = new HikariDataSource();

//        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        dataSource.setMaximumPoolSize(100);
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/groceriesdb?createDatabaseIfNotExist=true&&useTimezone=true&serverTimezone=UTC");
//        dataSource.addDataSourceProperty("url", env.getProperty("spring.datasource.jdbc-url"));
        dataSource.addDataSourceProperty("user", env.getProperty("spring.datasource.username"));
        dataSource.addDataSourceProperty("password", env.getProperty("spring.datasource.password"));
        dataSource.addDataSourceProperty("cachePrepStmts", true);
        dataSource.addDataSourceProperty("prepStmtCacheSize", 250);
        dataSource.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        dataSource.addDataSourceProperty("useServerPrepStmts", true);
        return dataSource;
    }

    @Bean(name="entityManagerFactory")
    public EntityManagerFactory entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        entityManager.setPackagesToScan("com.iyengarcoders.groceries.entity");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManager.setPersistenceUnitName("default");
        entityManager.setJpaVendorAdapter(vendorAdapter);
        entityManager.setJpaProperties(additionalProperties());
        entityManager.afterPropertiesSet();

        return entityManager.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties additionalProperties() {


        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("spring.jpa.hibernate.ddl-auto", hibernatehbm2ddl);
//        properties.setProperty("spring.jpa.properties.hibernate.dialect", hibernateDialect);
//        properties.setProperty("spring.jpa.properties.hibernate.show_sql", "spring.jpa.properties.hibernate.show_sql");
//        properties.setProperty("spring.jpa.properties.hibernate.use_sql_comments", "spring.jpa.properties.hibernate.use_sql_comments");
//        properties.setProperty("spring.jpa.properties.hibernate.format_sql", "spring.jpa.properties.hibernate.format_sql");
//        properties.setProperty("hibernate.search.default.indexBase", hibernateIndexBase);

        return properties;
    }


}
