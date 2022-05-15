package com.mbsystems.demotestcontainer05;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbsystems.demotestcontainer05.entities.Student;
import com.mbsystems.demotestcontainer05.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.org.hamcrest.CoreMatchers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class Demotestcontainer05ApplicationTests extends AbstractContainerBaseTest {

    @Autowired
    private StudentRepository studentRepository;

    private JacksonTester<List<Student>> json;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    void contextLoads() {
        System.out.println("contextLoads");
    }

    @Test
    void givenStudents_whenGetAllStudents_thenListOfStudents() throws Exception {
        //given
        List<Student> studentList = List.of(Student.builder()
                .firstName("Basil").lastName("Williams").email("bmk@yahoo.com").build(),
                Student.builder().firstName("Mary").lastName("Kay").email("mary.kay@yahoo.com").build());

        this.studentRepository.saveAll( studentList );

        //when
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/students"));
//        MockHttpServletResponse response = mockMvc.perform(get("/api/v1/students").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        //then
        response.andExpect(MockMvcResultMatchers.status().isOk());
        //response.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(studentList.size())));
    }
}
