package kr.co.bomb.sample.common.config;

import kr.co.bomb.sample.common.filter.BombSiteMeshFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

@Configuration
public class WebConfig  extends WebMvcAutoConfiguration {

    @Value("${spring.profiles.active}")
    private String profiles;



    @Bean
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new BombSiteMeshFilter());
        return filter;
    }

    @Bean
    public Properties  properties() throws Exception{
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(new ClassPathResource("config/application-"+profiles+".yml"),new ClassPathResource("config/application.yml"));
        propertySourcesPlaceholderConfigurer.setProperties(yamlPropertiesFactoryBean.getObject());
        Properties  properties = yamlPropertiesFactoryBean.getObject();
        return properties;
    }


}
