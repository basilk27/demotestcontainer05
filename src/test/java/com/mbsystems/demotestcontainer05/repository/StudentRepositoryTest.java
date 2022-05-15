package com.mbsystems.demotestcontainer05.repository;

import com.mbsystems.demotestcontainer05.AbstractContainerBaseTest;
import com.mbsystems.demotestcontainer05.entities.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private StudentRepository studentRepository;
    private Student student;

    @BeforeEach
    void setUp() {
        student = Student.builder()
                .email("zzz@yahoo.com")
                .firstName("John")
                .lastName("Walker")
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addStudent() {
        //given
        //when
        Student resultStudent = this.studentRepository.save( student );

        //then
        assertThat( resultStudent ).isNotNull();
        assertThat( resultStudent.getEmail() ).isEqualTo( student.getEmail() );
    }
}