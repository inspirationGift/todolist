package com.softserve.itacademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Email
    private String email;
    @NotBlank(message = "The firstName cannot be empty")
    @Column(nullable = false)
    private String firstName;
    @NotBlank(message = "The lastName cannot be empty")
    @Column(nullable = false)
    private String lastName;
    @NotBlank(message = "The password cannot be empty")
//    @Pattern(regexp = "[a..z]")
    private String password;

    @NotNull
    @ManyToOne
    private Role role;

    @Transient
    @OneToMany
    @JoinTable(inverseJoinColumns = @JoinColumn(name = "collaborator_id"))
    private List<ToDoCollaborator> collaborator;

    public void setRole(Role role) {
        this.role = role;
    }
}
