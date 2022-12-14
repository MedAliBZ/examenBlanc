package com.example.examclassroom.service;

import com.example.examclassroom.entity.Project;
import com.example.examclassroom.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void assignProjectToUser(int projectId, int userId);
    void assignProjectToClient(int projectId, String firstName, String lastName);
    List<Project> getProjectsByScrumMaster(String fName, String lName);
}
