package com.example.user.login.authentication.app.user.login.auth.models;

public enum UserStates {
    NEW_USER,
    EXISTING_USER,
    USER_NOT_FOUND,
    USER_SIGNED_IN,
    USER_SIGNED_OUT,

    USER_FOUND_UNABLE_TO_SIGN_IN,
    NOT_A_USER_UNABLE_TO_SIGN_IN,
    USER_FOUND_UNABLE_TO_SIGN_OUT,
    NOT_A_USER_UNABLE_TO_SIGN_OUT,

}
