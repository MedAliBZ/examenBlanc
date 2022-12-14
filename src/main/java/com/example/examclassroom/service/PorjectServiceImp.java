package com.example.examclassroom.service;

import com.example.examclassroom.entity.Project;
import com.example.examclassroom.entity.Sprint;
import com.example.examclassroom.repository.ProjectRepository;
import com.example.examclassroom.repository.SprintRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class PorjectServiceImp implements ProjectService {
    final private ProjectRepository projectRepository;
    final private SprintRepository sprintRepository;

//    @Transactional
    @Override
    public Project addProject(Project project) {
        List<Sprint> sprint = project.getSprintList();
        sprint.stream().forEach(s -> {
            s.setProjet(project);
            sprintRepository.save(s);
        });

        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllCurrentProject() {
        return projectRepository.findAll().stream()
                        .filter(project -> project.getSprintList().stream()
                                .anyMatch(sprint -> sprint.getStartDate().before(new Date()))
                        ).collect(Collectors.toList());
    }

    @Scheduled(fixedRate = 30)
    public void getNbrSprintByCurrentProject(){
        List<Project> list = getAllCurrentProject();
        list.stream().forEach(e -> log.info(String.valueOf(e.getSprintList().size())));

    }

}
