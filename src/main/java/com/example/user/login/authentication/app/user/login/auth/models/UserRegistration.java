package com.example.user.login.authentication.app.user.login.auth.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "AppUser")
@AllArgsConstructor
public class UserRegistration {

    @MongoId
    private String id;

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    private LoginStatus status;

}
