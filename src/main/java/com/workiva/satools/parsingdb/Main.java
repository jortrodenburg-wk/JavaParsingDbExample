package com.workiva.satools.parsingdb;

import com.google.inject.Guice;
import com.workiva.satools.parsingdb.helpers.dependencyinjection.ProjectControllerModuleDI;
import com.workiva.satools.parsingdb.helpers.dependencyinjection.ProjectRepositoryModuleDI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Main {

    public static void main(String[] args) {
        SetupDependencyInjection();
        SpringApplication.run(Main.class, args);
    }

    private static void SetupDependencyInjection(){
        Guice.createInjector(new ProjectControllerModuleDI());
        Guice.createInjector(new ProjectRepositoryModuleDI());
    }
}