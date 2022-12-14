package com.example.examclassroom.service;

import com.example.examclassroom.entity.Project;
import com.example.examclassroom.entity.Sprint;
import com.example.examclassroom.repository.ProjectRepository;
import com.example.examclassroom.repository.SprintRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class SprintServiceImp implements SprintService {
    final private SprintRepository sprintRepository;
    final private ProjectRepository projectRepository;

    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Project project = projectRepository.findById(idProject).orElse(null);
        if(project != null){
            sprint.setProjet(project);
            sprintRepository.save(sprint);
        }

    }
}
