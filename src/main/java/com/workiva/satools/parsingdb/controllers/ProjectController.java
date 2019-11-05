package com.workiva.satools.parsingdb.controllers;

import com.google.inject.Inject;
import com.workiva.satools.parsingdb.models.Project;
import com.workiva.satools.parsingdb.services.IProjectService;
import com.workiva.satools.parsingdb.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@Component
public class ProjectController {

    private ProjectService _projectService;

    @Inject
    public ProjectController(IProjectService projectService) {
        _projectService = (ProjectService) projectService;
    }

    @RequestMapping(value = "/getProjects/{projectId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getProjects(@PathVariable("projectId") final int projectId) throws SQLException, ClassNotFoundException {
        if (projectId < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid projectId");
        }

        List<Project> projects = _projectService.getProjectsById(projectId);
        return ResponseEntity.status(HttpStatus.OK).body(projects);
    }
}
