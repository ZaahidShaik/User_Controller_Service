package com.example.user.login.authentication.app.user.login.auth.service.LoginService;

import com.example.user.login.authentication.app.user.login.auth.models.UserLogin;
import com.example.user.login.authentication.app.user.login.auth.models.UserStates;

import java.util.List;

public interface LoginService {

    Boolean isUserLoggedIn(UserLogin UserInfo);

    Boolean isUserAuthentic(UserLogin UserInfo);

    UserStates getUserLoggedIn(UserLogin UserInfo);

    UserStates getUserLoggedOut(UserLogin UserInfo);

}
