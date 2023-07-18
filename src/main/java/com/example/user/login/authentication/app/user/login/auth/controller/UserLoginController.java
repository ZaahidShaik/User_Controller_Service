package com.example.user.login.authentication.app.user.login.auth.controller;

import com.example.user.login.authentication.app.user.login.auth.models.UserLogin;
import com.example.user.login.authentication.app.user.login.auth.models.UserRegistration;
import com.example.user.login.authentication.app.user.login.auth.service.LoginService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserLoginController {

    @Autowired
    private LoginService loginService;


    /**
     * Get User Logged IN
     * Param: User Registration Model  `UserRegistration`
     * Return: Login status ACTIVE or IN_ACTIVE;
     * */
    @PostMapping (value = "/user/login")
    public ResponseEntity<?> getUserLoggedIn(@RequestBody UserLogin userInfo){
        System.out.println(userInfo);
        return ResponseEntity.ok(loginService.getUserLoggedIn(userInfo));
    }

//    {
//        "userName": "",
//        "password": ""
//    }


    /**
     * Get User Logged OUT
     * Param: User Registration Model  `UserRegistration`
     * Return: Login status ACTIVE or IN_ACTIVE;
     **/
    @PostMapping (value = "/user/logout")
    public ResponseEntity<?> getUserLoggedOut(@RequestBody UserLogin userInfo){
        System.out.println(userInfo);
        return ResponseEntity.ok(loginService.getUserLoggedOut(userInfo));
    }


}
