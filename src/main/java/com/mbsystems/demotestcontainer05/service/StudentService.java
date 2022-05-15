package com.mbsystems.demotestcontainer05.service;

import com.mbsystems.demotestcontainer05.entities.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student );
    List<Student> getAllStudents();
}
