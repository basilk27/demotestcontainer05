package com.mbsystems.demotestcontainer05.service;

import com.mbsystems.demotestcontainer05.entities.Student;
import com.mbsystems.demotestcontainer05.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return this.studentRepository.save( student );
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }
}
