package com.example.examclassroom.controller;

import com.example.examclassroom.entity.Project;
import com.example.examclassroom.entity.Sprint;
import com.example.examclassroom.entity.User;
import com.example.examclassroom.service.ProjectService;
import com.example.examclassroom.service.SprintService;
import com.example.examclassroom.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class MainRestController {
    final private ProjectService projectService;
    final private UserService userService;
    final private SprintService sprintService;

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/project")
    public Project addProject(@RequestBody Project project){
        return projectService.addProject(project);
    }

    @GetMapping("/assign/{projectId}/{userId}")
    public void assignProjectToUser(@PathVariable int projectId, @PathVariable int userId){
        userService.assignProjectToUser(projectId,userId);
    }

    @GetMapping("/assign/{projectId}/{firstName}/{lastName}")
    public void assignProjectToClient(@PathVariable int projectId, @PathVariable String firstName, @PathVariable String lastName){
        userService.assignProjectToClient(projectId,firstName, lastName);
    }

    @GetMapping("/allCurrent")
    public List<Project> getAllCurrentProject(){
        return projectService.getAllCurrentProject();
    }

    @GetMapping("/getByScrum/{fName}/{lName}")
    public List<Project> getProjectsByScrumMaster(@PathVariable String fName, @PathVariable String lName){
        return userService.getProjectsByScrumMaster(fName,lName);
    }

    @PostMapping("/assignSprint/{idProject}")
    public void addSprintAndAssignToProject(@RequestBody Sprint sprint, @PathVariable int idProject){
        sprintService.addSprintAndAssignToProject(sprint,idProject);
    }
}
