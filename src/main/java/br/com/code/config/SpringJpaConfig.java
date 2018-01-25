package br.com.code.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/*@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "br.com.code.dao",
entityManagerFactoryRef = "entityManagerFactory",
transactionManagerRef = "transactionManager")*/
public class SpringJpaConfig {
	
}
