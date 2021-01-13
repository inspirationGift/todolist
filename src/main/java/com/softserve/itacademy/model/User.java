package com.softserve.itacademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @NotBlank(message = "The email cannot be empty")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "The firstName cannot be empty")
    @Column(name = "first_name", nullable = false)
//    @Pattern(regexp = "([A-Za-z]+),\\s*([A-Za-z]+)\\s*([A-Za-z]+)")
    @Pattern(regexp = "[A-Z][a-z]+-[A-Z][a-z]+")
    private String firstName;

    @NotBlank(message = "The last_name cannot be empty")
    @Column(name = "last_name", nullable = false)
    @Pattern(regexp = "[A-Z][a-z]+-[A-Z][a-z]+")
    private String lastName;

    @NotBlank(message = "The password cannot be empty")
    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")
    @Column(nullable = false)
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
