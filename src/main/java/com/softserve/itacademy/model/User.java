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

@Entity
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_roleId"))
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @Pattern(regexp = "[a..z]")
    private String password;
    @NotNull
    private long roleId;

    public void setRole(Role role) {
        this.roleId = role.getId();
    }
}
