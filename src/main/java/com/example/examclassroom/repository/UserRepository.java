package com.example.examclassroom.repository;

import com.example.examclassroom.entity.Project;
import com.example.examclassroom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    User getUserByFNameAndLName(String FName, String LName);
    User findByFirstNameAndLastName(String firstName, String lastName);
}
