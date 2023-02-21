package com.example.web;

import com.example.domain.Project;
import com.example.exception.ProjectObjectValidationException;
import com.example.service.ProjectService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/project")
public class ProjectController {

    @Autowired
    private ProjectObjectValidationException projectObjectValidationException;
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @ApiOperation(value = "Add new project", consumes = "Project Data")
    @PostMapping("/addProject")
    public ResponseEntity<?> createProject(@Valid @RequestBody Project project, BindingResult result) {
        log.info("ProjectController createProject method accessed");
        ResponseEntity<?> errorMap = projectObjectValidationException.validationException(result);
        if (errorMap != null)
            return errorMap;
        Project response = projectService.saveProject(project);
        log.info("Response of Create Project: " + response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Returns project with matched projectIdentifier", response = Project.class)
    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProject(@PathVariable String projectId) {
        log.info("ProjectController getProject method accessed");
        return new ResponseEntity<>(projectService.findByProjectIdentifier(projectId), HttpStatus.OK);
    }

    @ApiOperation(value = "Returns total number of projects", response = List.class)
    @GetMapping("/allProjects")
    public List<Project> getAllProjects() {
        log.info("ProjectController getAllProjects method accessed");
        return projectService.findAllProjects();
    }

    @ApiOperation("Update a project with matched projectIdentifier")
    @PutMapping("/{projectId}")
    public ResponseEntity<?> updateProject(@PathVariable String projectId, @Valid @RequestBody Project project, BindingResult result) {
        log.info("ProjectController updateProject method accessed");
        ResponseEntity<?> errorMap = projectObjectValidationException.validationException(result);
        if (errorMap != null)
            return errorMap;
        projectService.updateProject(projectId, project);
        return new ResponseEntity<>(projectService.findByProjectIdentifier(projectId), HttpStatus.OK);
    }

    @ApiOperation("Delete a project with matched projectIdentifier")
    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId) {
        log.info("ProjectController deleteProject method accessed");
        projectService.deleteByProjectIdentifier(projectId);
        return new ResponseEntity<>("Project with id " + projectId + " was deleted", HttpStatus.OK);
    }



}
