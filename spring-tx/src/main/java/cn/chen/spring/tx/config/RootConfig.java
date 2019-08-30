package cn.chen.spring.tx.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("cn.chen.spring.tx")
@MapperScan(basePackages = "cn.chen.spring.tx.dao")
@EnableTransactionManagement
public class RootConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new Resource[] {new ClassPathResource("mapper/OrderDaoMapper.xml")});

        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public DataSource dataSource() {
        PooledDataSource pooledDataSource =
                new PooledDataSource("com.mysql.jdbc.Driver",
                        "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8", "root", "");
        pooledDataSource.setDefaultAutoCommit(false);
        return pooledDataSource;
    }
}
