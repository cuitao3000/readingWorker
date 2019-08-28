package com.cc.readingWorker.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Bean(name = "readingDataSource")
    @ConfigurationProperties(prefix = "datasource.reading")
    public DataSource readingDataSource() { return DataSourceBuilder.create().build(); }

    @Bean(name = "readingJdbcTemplate")
    public JdbcTemplate readingJdbcTemplate(@Qualifier("readingDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
