package com.pablos.spring.security.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("com.pablos.spring.security")
@EnableWebMvc
public class MyConfig {
    @Bean // для доступа к паролям в БД
    public DataSource dataSource() { // вместо <bean id="dataSource".../bean>
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver"); //вместо <property name="driverClass" value="com.mysql.cj.jdbc.Driver" />
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/my_db?useSSL=false&serverTimezone=UTC"); // вместо <property name="jdbcUrl"
            dataSource.setUser("bestuser");
            dataSource.setPassword("bestuser");
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }
    @Bean // префикс и суффикс для jsp страниц
    public ViewResolver vievResolver(){
        return new InternalResourceViewResolver("/WEB-INF/view/",".jsp");
    }
}
