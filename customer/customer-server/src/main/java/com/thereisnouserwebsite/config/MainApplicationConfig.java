package com.thereisnouserwebsite.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class MainApplicationConfig {

    @Profile({"local"})
    @PropertySource("classpath:local.properties")
    public static class LocalConfig {

        @Bean
        @Primary
        @ConfigurationProperties("database")
        public DataSource dataSource() {
            return DataSourceBuilder.create().build();
        }
    }
}
