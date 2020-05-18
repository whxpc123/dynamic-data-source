package com.example.dynamicdatasource.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.dynamicdatasource.dynamic",
        entityManagerFactoryRef = "dynamicEntityManagerFactory",
        transactionManagerRef= "dynamicTransactionManager"
)
public class DynamicConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.dynamic")
    public DataSourceProperties dynamicDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.dynamic")
    public DataSource dynamicDataSource() {
        return dynamicDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }


    @Bean(name = "dynamicEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean dynamicEntityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.example.dynamicdatasource.entity");
        factory.setDataSource(dynamicDataSource());
        return factory;
    }
    @Bean("dynamicTransactionManager")
    public PlatformTransactionManager  dynamicTransactionManager(
            final @Qualifier("dynamicEntityManagerFactory") LocalContainerEntityManagerFactoryBean dynamicEntityManagerFactory) {
        return new JpaTransactionManager(dynamicEntityManagerFactory.getObject());
    }
}
