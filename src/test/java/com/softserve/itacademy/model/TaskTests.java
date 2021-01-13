package com.softserve.itacademy.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskTests {
    private static State state;
    private static Task task;

    @BeforeAll
    static void init() {
        state = new State();
        state.setName("New State");
        task = new Task();
        task.setName("New Task");
        task.setPriority(Priority.MEDIUM);
    }

    @Test
    public void checkCreateTask() {
        Task expected = new Task();
        expected.setName("New Task");
        expected.setPriority(Priority.MEDIUM);
        String test = expected.toString();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Task>> violations = validator.validate(task);
        assertEquals(0, violations.size());
        assertEquals(test, expected.toString());
    }

    @Test
    public void checkAGetSomFieldTask() {
        String name = task.getName();
        long id = task.getId();
        String st = state.getName();
        assertEquals(name, task.getName());
        assertEquals(id, task.getId());
        assertEquals(st, state.getName());
    }
}

