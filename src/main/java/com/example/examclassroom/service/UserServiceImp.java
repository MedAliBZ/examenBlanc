package com.example.examclassroom.service;

import com.example.examclassroom.entity.Project;
import com.example.examclassroom.entity.User;
import com.example.examclassroom.repository.ProjectRepository;
import com.example.examclassroom.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserService{
    final private UserRepository userRepository;
    final private ProjectRepository projectRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void assignProjectToUser(int projectId, int userId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        if (project != null && user != null){
            user.getProjectList().add(project);
            userRepository.save(user);
        }
    }

    @Override
    public void assignProjectToClient(int projectId, String firstName, String lastName) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User user = userRepository.findByFirstNameAndLastName(firstName,lastName);
        if (project != null && user != null){
            user.getProjects().add(project);
            userRepository.save(user);
        }
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
        User user = userRepository.findByFirstNameAndLastName(fName,lName);
        return user != null ? user.getProjectList() : null;
    }


}
