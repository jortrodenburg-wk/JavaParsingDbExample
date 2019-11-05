package com.workiva.satools.parsingdb.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Project {
    public int ProjectID;
    public String AccountID;
    public String Name;
    public String Type;
    public String CreatedBy;
    public String CreatedDate;
    public String ModifiedBy;
    public String ModifiedDate;
    public String DeletedBy;
    public String DeletedDate;
    public short IsDeleted;
    public String DisabledBy;
    public String DisabledDate;
    public short IsDisabled;

    public Project(){}

    public static List<Project> Project(ResultSet unmappedDatabaseEntries) throws SQLException {
        List<Project> mappedProjects = new ArrayList<>();

        while(unmappedDatabaseEntries.next()) {

            Project project = new Project();
            project.ProjectID = unmappedDatabaseEntries.getInt("ProjectID");
            project.AccountID = unmappedDatabaseEntries.getString("AccountID");
            project.Name = unmappedDatabaseEntries.getString("Name");
            project.Type = unmappedDatabaseEntries.getString("Type");
            project.CreatedBy = unmappedDatabaseEntries.getString("CreatedBy");
            project.CreatedDate = unmappedDatabaseEntries.getString("CreatedDate");
            project.ModifiedBy = unmappedDatabaseEntries.getString("ModifiedBy");
            project.ModifiedDate = unmappedDatabaseEntries.getString("ModifiedDate");
            project.DeletedBy = unmappedDatabaseEntries.getString("DeletedBy");
            project.DeletedDate = unmappedDatabaseEntries.getString("DeletedDate");
            project.IsDeleted = unmappedDatabaseEntries.getShort("IsDeleted");
            project.DisabledBy = unmappedDatabaseEntries.getString("DisabledBy");
            project.DisabledDate = unmappedDatabaseEntries.getString("DisabledDate");
            project.IsDisabled = unmappedDatabaseEntries.getShort("IsDisabled");

            mappedProjects.add(project);
        }

        return mappedProjects;
    }
}
