package com.springbootforecast.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    @Column(columnDefinition = "varchar(255) default 'ROLE_USER'")
    private final String role = "ROLE_USER";
    @Column(columnDefinition = "integer default 1")
    private final Integer enabled = 1;
}
