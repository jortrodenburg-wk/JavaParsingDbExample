package com.workiva.satools.parsingdb.repositories;

import com.workiva.satools.parsingdb.models.Project;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public interface IProjectRepository {
    List<Project> getProjectsById(int projectId) throws SQLException, ClassNotFoundException;
}
