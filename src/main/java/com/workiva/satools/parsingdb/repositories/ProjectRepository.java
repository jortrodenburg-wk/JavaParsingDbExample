package com.workiva.satools.parsingdb.repositories;

import com.workiva.satools.parsingdb.helpers.databaseconnector.ParsingDatabaseConnection;
import com.workiva.satools.parsingdb.models.Project;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Component
public class ProjectRepository implements IProjectRepository {
    @Override
    public List<Project> getProjectsById(int projectId) throws SQLException, ClassNotFoundException {
        Connection databaseConnection = new ParsingDatabaseConnection().GetDatabaseConnection();

        String query = "SELECT * FROM Project WHERE ProjectId = " + projectId;
        Statement statement = databaseConnection.createStatement();
        ResultSet result = statement.executeQuery(query);

        return Project.Project(result);
    }
}
