package za.ac.nwu.as.repo.config;

import lombok.Value;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("za.ac.nwu.as.repo.persistence")
@EntityScan("za.ac.nwu.as.domain.persistence")
@PropertySource(value = "classpath:application-db.properties")
public class RepositoryConfig {

    private static final String[] ENTITY_PACKAGES_TO_SCAN = {"za.ac.nwu.as.domain.persistence"};
    private static final String PERSISTENCE_UNIT_NAME = "account.system.persistence";

    @Value("${spring.datasource.url}")
    private String datasourseUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(buildJpaProperties());
        entityManagerFactoryBean.setPersistenceUnitName(PERSISTENCE_UNIT_NAME)

        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public DataSource dataSource() {
        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setUser(username);
            dataSource.setPassword(password);
            dataSource.setURL(datasourseUrl);
            dataSource.setImplicitCachingEnabled(true);
            return dataSource;
        } catch (SQLException e){
            //TODO: Log out that Repository Configured
            throw new RuntimeException("Unable to connect to the DB", e);
        }
    }

}



