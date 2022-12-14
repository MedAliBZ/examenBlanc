package com.example.examclassroom.service;

import com.example.examclassroom.entity.Project;

import java.util.List;

public interface ProjectService {
    Project addProject(Project project);
    List<Project> getAllCurrentProject();

}
