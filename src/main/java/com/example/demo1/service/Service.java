package com.example.demo1.service;

import com.example.demo1.pojo.Project;
import com.example.demo1.repository.Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private Repository repository;

    public List<Project> getProjects() {
        List<Project> list = new ArrayList<>();
        list.addAll(repository.findAll());
        return list;
    }

    public Project createProject(Project project) {
        return repository.saveAndFlush(project);
    }

    public Project getProjectById(Long id) {
        Optional<Project> project = repository.findById(id);
        Project newProject= new Project();
        BeanUtils.copyProperties(newProject, project);
        return newProject;
    }

    public Project updateProjectById(Long id, Project project) {
        Optional<Project> existingProject = repository.findById(id);
        BeanUtils.copyProperties(project, existingProject);
        return repository.saveAndFlush( project);
    }

    public Project deleteProjectById(Long id) {
        Optional<Project> existingProject = repository.findById(id);
        Project project= new Project();
        BeanUtils.copyProperties(project, existingProject);
        repository.deleteById(id);
        return project;
    }
}
