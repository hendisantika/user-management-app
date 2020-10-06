package com.hendisantika.usermanagementapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * Project : user-management-app
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/20
 * Time: 07.36
 */
@Entity
@Table(name = "USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "roleName")
    private String roleName;

    @Column(name = "isActive")
    private boolean isActive;

    public User(String pFirstName, String pLastName, String pEmail, String pPassword, String pRoleName,
                boolean pIsActive) {
        firstName = pFirstName;
        lastName = pLastName;
        email = pEmail;
        password = pPassword;
        roleName = pRoleName;
        isActive = pIsActive;
    }
}
