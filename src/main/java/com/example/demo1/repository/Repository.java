package com.example.demo1.repository;

import com.example.demo1.pojo.Project;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Project,Long> {

}
