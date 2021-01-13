package com.softserve.itacademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Length(message = "name with minimum 3 and maximum 200 any symbols", min = 3, max = 200)
    @Pattern(regexp = "[(*[a-zA-Z])|*(\\s)|*\\_|*\\-|*(\\d)]")
    private String name;
    private String priority;
    @ManyToOne
    private State state;
    @ManyToOne
    private ToDo todo;

}
