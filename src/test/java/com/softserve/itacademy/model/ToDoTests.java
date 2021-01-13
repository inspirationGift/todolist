package com.softserve.itacademy.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class ToDoTests {
    private static Role mentorRole;
    private static Role traineeRole;
    private static User validUser;

    @BeforeAll
    static void init() {
        mentorRole = new Role();
        mentorRole.setName("MENTOR");
        traineeRole = new Role();
        traineeRole.setName("TRAINEE");
        validUser = new User();
        validUser.setEmail("valid@cv.edu.ua");
        validUser.setFirstName("Valid-Name");
        validUser.setLastName("Valid-Name");
        validUser.setPassword("qwQW12!@");
        validUser.setRole(traineeRole);
    }

    @Test
    public void checkCreateToDo() {

        ToDo todo = new ToDo();
        todo.setTitle("Som title");
        todo.setCreatedAt(LocalDateTime.now());
        todo.setOwner(validUser);
        String expected = todo.toString();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ToDo>> violations = validator.validate(todo);
        assertEquals(0, violations.size());
        assertEquals(expected, todo.toString());

    }

    @Test
    public void checkCreateInvalidTitleToDo() {
        ToDo todo = new ToDo();
        todo.setTitle("input");
        todo.setCreatedAt(LocalDateTime.now());
        todo.setOwner(validUser);
        assertEquals("input", todo.getTitle());
    }


    @Test
    public void checkSetTaskList() {

        List<Task> list = new ArrayList<>();
        list.add(new Task());
        list.add(new Task());
        ToDo todo = new ToDo();
        todo.setTitle("input");
        todo.setCreatedAt(LocalDateTime.now());
        todo.setOwner(validUser);
        todo.setTasks(list);
        assertEquals("input", todo.getTitle());
        assertEquals(list, todo.getTasks());
    }

}
