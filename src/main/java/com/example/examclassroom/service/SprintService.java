package com.example.examclassroom.service;

import com.example.examclassroom.entity.Sprint;

public interface SprintService {
    void addSprintAndAssignToProject(Sprint sprint, int idProject);
}
