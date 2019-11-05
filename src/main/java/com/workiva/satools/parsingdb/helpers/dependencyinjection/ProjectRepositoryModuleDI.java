package com.workiva.satools.parsingdb.helpers.dependencyinjection;

import com.google.inject.AbstractModule;
import com.workiva.satools.parsingdb.repositories.IProjectRepository;
import com.workiva.satools.parsingdb.repositories.ProjectRepository;

public class ProjectRepositoryModuleDI extends AbstractModule {

    @Override
    protected void configure(){
        bind(IProjectRepository.class).to(ProjectRepository.class);
    }
}
