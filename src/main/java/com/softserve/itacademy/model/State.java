package com.softserve.itacademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "states")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(message = "from 1 to 20 latin letters, numbers, dash, space and underscore", min = 1, max = 20)
    private String name;
    @OneToMany(mappedBy = "state")
    private List<Task> tasks;

}
