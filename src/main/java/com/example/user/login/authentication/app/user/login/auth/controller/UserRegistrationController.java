package com.example.user.login.authentication.app.user.login.auth.controller;

import com.example.user.login.authentication.app.user.login.auth.models.UserRegistration;
import com.example.user.login.authentication.app.user.login.auth.service.RegistrationService.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserRegistrationController {

    @Autowired
    private RegistrationService registrationService;

    /**
     * POST: Register User
     * @Param: User Registration Model  `UserRegistration`
     * Return: status True;
     **/
    @PostMapping(value = "/user/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistration userInfo){
        System.out.println(userInfo);
        return ResponseEntity.ok(registrationService.getNewUserRegistered(userInfo));
    }

//    {
//            "firstName": "TestUser1",
//            "lastName" : "UserLS",
//            "userName" : "TestUser0",
//            "password" : "123548"
//    }

    /**
     * Get: Is Registered user
     * @Param: User Registration Model  `UserRegistration`
     * Returns: Boolean;
     **/
    @GetMapping(value = "/{username}/register/legal")
    public ResponseEntity<?> registerUsernameLegal(@PathVariable("username") String username){
//        System.out.println(username);
        return ResponseEntity.ok(registrationService.isUserRegistered(username));
    }

    /**
     * TODO: User Account Delete API.
     * */
}
