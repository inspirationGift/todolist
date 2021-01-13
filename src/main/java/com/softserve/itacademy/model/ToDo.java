package com.softserve.itacademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
//    @Column(nullable = false)
    private LocalDateTime createdAt;
    @NotNull(message = "Not empty title")
    @Size(min = 3, max = 200)
    @Column(nullable = false)
    private String title;

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
