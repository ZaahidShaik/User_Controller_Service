package com.example.user.login.authentication.app.user.login.auth.service.RegistrationService;

import com.example.user.login.authentication.app.user.login.auth.models.LoginStatus;
import com.example.user.login.authentication.app.user.login.auth.models.UserRegistration;
import com.example.user.login.authentication.app.user.login.auth.models.UserStates;
import com.example.user.login.authentication.app.user.login.auth.repository.UserRegistrationRepository;
import com.example.user.login.authentication.app.user.login.auth.service.ValidationService.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Autowired
    private ValidationService validationService;

    @Override
    public Boolean isUserRegistered(String username) {

        return validationService.isUserNameLegal(username);
    }

    @Override
    public UserRegistration getNewUserRegistered(UserRegistration UserInfo) {
        UserInfo.setStatus(LoginStatus.IN_ACTIVE);
        return userRegistrationRepository.save(UserInfo);
    }

    @Override
    public List<UserRegistration> getAllRegisteredUsers() {
        return userRegistrationRepository.findAll();
    }
}
