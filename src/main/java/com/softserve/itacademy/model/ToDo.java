package com.softserve.itacademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todos")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate createdAt;
    private String title;
//    private long ownerId;

    @OneToMany(mappedBy = "todo")
    private List<Task> tasks;

    @ManyToOne
    private User owner;

    @Transient
    @OneToMany
    @JoinTable(inverseJoinColumns = @JoinColumn(name = "todo_id"))
    private List<ToDoCollaborator> toDoCollaborators;

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
