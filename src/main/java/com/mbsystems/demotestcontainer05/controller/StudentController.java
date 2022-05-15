package com.mbsystems.demotestcontainer05.controller;

import com.mbsystems.demotestcontainer05.entities.Student;
import com.mbsystems.demotestcontainer05.service.StudentService;
import com.mbsystems.demotestcontainer05.service.StudentServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentServiceImp studentService;

    public StudentController(StudentServiceImp studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public Student createStudent( @RequestBody Student student ) {
        return this.studentService.createStudent( student );
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return this.studentService.getAllStudents();
    }
}
