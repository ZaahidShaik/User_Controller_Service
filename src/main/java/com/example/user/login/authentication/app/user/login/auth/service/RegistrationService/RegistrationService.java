package com.example.user.login.authentication.app.user.login.auth.service.RegistrationService;

import com.example.user.login.authentication.app.user.login.auth.models.UserLogin;
import com.example.user.login.authentication.app.user.login.auth.models.UserRegistration;
import com.example.user.login.authentication.app.user.login.auth.models.UserStates;

import java.util.List;

public interface RegistrationService {
    Boolean isUserRegistered(String username);

    UserRegistration getNewUserRegistered(UserRegistration UserInfo);

    List<UserRegistration> getAllRegisteredUsers();

}
