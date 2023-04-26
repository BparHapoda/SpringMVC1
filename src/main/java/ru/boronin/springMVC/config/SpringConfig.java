package ru.boronin.springMVC.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ru.boronin.springMVC")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {
    private final ApplicationContext context;
@Autowired
    public SpringConfig (ApplicationContext context){
    this.context = context;
}

    @Bean
    public FreeMarkerViewResolver freemarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".ftl");
        return resolver;
    }
    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("");
        return freeMarkerConfigurer;
    }
        @Bean
    public DataSource dataSource(){
    DriverManagerDataSource dataSource=new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
dataSource.setUrl("jdbc:postgresql://localhost:5432/signInDb");
dataSource.setUsername("postgres");
dataSource.setPassword("12345");

    return dataSource;
}

@Bean
    public JdbcTemplate jdbcTemplate(){
    return new JdbcTemplate(dataSource());
}

}
