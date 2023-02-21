package com.example.service;

import com.example.domain.Project;
import com.example.exception.DataAlreadyExistException;
import com.example.exception.DataNotFoundException;
import com.example.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveProject(Project project) {
        try {
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new DataAlreadyExistException("Project already exist");
        }
    }

    public Project findByProjectIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId);
        if (project == null) {
            throw new NullPointerException("The object is null");
        }
        return project;
    }

    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    public void updateProject(String projectId, Project project) {
        projectRepository.save(project);
    }

    public void deleteByProjectIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId);
        if (project == null) {
            throw new DataNotFoundException(projectId + " doesn't exist");
        }
        projectRepository.delete(project);
    }
}
