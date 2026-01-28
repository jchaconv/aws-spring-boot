package com.vilelo.movieservice;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestContainersConfiguration {

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer() {
        var dockerImage = DockerImageName.parse("public.ecr.aws/docker/library/postgres:18").asCompatibleSubstituteFor("postgres");
        return new PostgreSQLContainer<>(dockerImage)
                .withDatabaseName("movie")
                .withInitScript("init-db.sql");
    }

}
