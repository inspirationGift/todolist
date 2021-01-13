package com.softserve.itacademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(message = "name with minimum 3 and maximum 200 any symbols", min = 3, max = 200)
    @NotBlank(message = "name with minimum 3 and maximum 200 any symbols")
//    @Pattern(regexp = "[(*[a-zA-Z])|*(\\s)|*\\_|*\\-|*(\\d)]")
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;
    @ManyToOne(fetch = FetchType.LAZY)
    private State state;
    @ManyToOne(fetch = FetchType.LAZY)
    private ToDo todo;

}
