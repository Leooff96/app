package br.com.code.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class SpringJpaConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://mysql-mysqlleooff.193b.starter-ca-central-1.openshiftapps.com:3306/apps?createDatabaseIfNotExist=true");
		ds.setUsername("leooff");
		ds.setPassword("leo1230");
		return ds;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setPackagesToScan("br.com.code.domain");
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factory.setJpaProperties(jpaProperties());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	private Properties jpaProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		return props;

	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory factory) {
		JpaTransactionManager tx = new JpaTransactionManager();
		tx.setEntityManagerFactory(factory);
		tx.setJpaDialect(new HibernateJpaDialect());
		return tx;
	}
}
