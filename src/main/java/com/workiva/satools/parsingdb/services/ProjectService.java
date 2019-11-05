package com.workiva.satools.parsingdb.services;

import com.google.inject.Inject;
import com.workiva.satools.parsingdb.models.Project;
import com.workiva.satools.parsingdb.repositories.IProjectRepository;
import com.workiva.satools.parsingdb.repositories.ProjectRepository;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class ProjectService implements IProjectService {
    private ProjectRepository _projectRepository;

    @Inject
    public ProjectService(IProjectRepository projectRepository){
        _projectRepository = (ProjectRepository) projectRepository;
    }

    @Override
    public List<Project> getProjectsById(int projectId) throws SQLException, ClassNotFoundException {
        return _projectRepository.getProjectsById(projectId);
    }
}
