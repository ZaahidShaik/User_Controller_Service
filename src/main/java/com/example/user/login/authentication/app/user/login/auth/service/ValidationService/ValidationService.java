package com.example.user.login.authentication.app.user.login.auth.service.ValidationService;

import com.example.user.login.authentication.app.user.login.auth.models.UserLogin;

public interface ValidationService {

    Boolean isUserDetailsValid(final UserLogin user);

    Boolean isUserLoginValid(final UserLogin user);

    Boolean isUserNameLegal(final String username);

}
