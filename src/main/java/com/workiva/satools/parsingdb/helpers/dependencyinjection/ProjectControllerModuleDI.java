package com.workiva.satools.parsingdb.helpers.dependencyinjection;

import com.google.inject.AbstractModule;
import com.workiva.satools.parsingdb.repositories.IProjectRepository;
import com.workiva.satools.parsingdb.repositories.ProjectRepository;
import com.workiva.satools.parsingdb.services.IProjectService;
import com.workiva.satools.parsingdb.services.ProjectService;
import org.springframework.stereotype.Component;

@Component
public class ProjectControllerModuleDI extends AbstractModule {

    @Override
    protected void configure(){
        bind(IProjectService.class).to(ProjectService.class);
        bind(IProjectRepository.class).to(ProjectRepository.class);
    }
}
