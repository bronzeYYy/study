package cn.chen.spring.data.jpa;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "cn.chen.spring.data.jpa.dao") // dao扫描
@EnableTransactionManagement
public class RootConfig {

    /**
     * EnableJpaRepositories dao扫描
     * dataSource
     * entityManagerFactory 数据源 实体类扫描
     * 事务管理器 jpa事务管理器
     * 实体类的实体 表 主键等注解
     */



    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        // 实体类的扫描
        localContainerEntityManagerFactoryBean.setPackagesToScan("cn.chen.spring.data.jpa.model");
        localContainerEntityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(DataSource dataSource) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    /*@Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }*/

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("9674464343..as");
        return driverManagerDataSource;
    }
}
