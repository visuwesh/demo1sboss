package com.example.demo1.controller;

import com.example.demo1.pojo.Project;
import com.example.demo1.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("demo1/api/v1/")
public class Controller {

    @Autowired
    private Service service;

    @RequestMapping(value = "projects", method = RequestMethod.GET)
    public List<Project> list() {
        return service.getProjects();
    }

    @RequestMapping(value = "projects", method = RequestMethod.POST)
    public Project create(@RequestBody Project consultant) {
        return service.createProject(consultant);
    }

    @RequestMapping(value = "projects/{id}", method = RequestMethod.GET)
    public Project get(@PathVariable Long id) {
        return service.getProjectById(id);
    }

    @RequestMapping(value = "projects/{id}", method = RequestMethod.PUT)
    public Project update(@PathVariable Long id, @RequestBody Project shipwreck) {
        return service.updateProjectById(id, shipwreck);
    }

    @RequestMapping(value = "projects/{id}", method = RequestMethod.DELETE)
    public Project delete(@PathVariable Long id) {
        return service.deleteProjectById(id);
    }

}