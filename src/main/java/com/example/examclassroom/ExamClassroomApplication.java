package com.example.examclassroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExamClassroomApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamClassroomApplication.class, args);
    }

}
