package com.example.user.login.authentication.app.user.login.auth.service.LoginService;

import com.example.user.login.authentication.app.user.login.auth.models.LoginStatus;
import com.example.user.login.authentication.app.user.login.auth.models.UserLogin;
import com.example.user.login.authentication.app.user.login.auth.models.UserRegistration;
import com.example.user.login.authentication.app.user.login.auth.models.UserStates;
import com.example.user.login.authentication.app.user.login.auth.repository.UserLoginRepository;
import com.example.user.login.authentication.app.user.login.auth.repository.UserRegistrationRepository;
import com.example.user.login.authentication.app.user.login.auth.service.ValidationService.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Autowired
    private ValidationService validationService;

    @Override
    public Boolean isUserLoggedIn(UserLogin UserInfo) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(UserInfo.getUserName()));
        UserRegistration userLogin = mongoTemplate.findOne(query, UserRegistration.class);

        if(userLogin.getUserName().isEmpty() && userLogin.getStatus() == LoginStatus.ACTIVE){
            return true;
        } else {
                return false;
        }

    }

    @Override
    public Boolean isUserAuthentic(UserLogin UserInfo) {
        return validationService.isUserLoginValid(UserInfo);
    }

    @Override
    public UserStates getUserLoggedIn(UserLogin UserInfo) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(UserInfo.getUserName()).and("password").is(UserInfo.getPassword()));
        UserRegistration userLogin = mongoTemplate.findOne(query, UserRegistration.class);



        if(userLogin.getUserName().isEmpty()){
            return UserStates.USER_NOT_FOUND;
        } else {
            if(userLogin.getStatus() == LoginStatus.IN_ACTIVE) {
                userLogin.setStatus(LoginStatus.ACTIVE);
                mongoTemplate.save(userLogin);
                return UserStates.USER_SIGNED_IN;
            }
            return UserStates.USER_FOUND_UNABLE_TO_SIGN_IN;

        }
    }

    @Override
    public UserStates getUserLoggedOut(UserLogin UserInfo) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(UserInfo.getUserName()).and("password").is(UserInfo.getPassword()));
        UserRegistration userLogin = mongoTemplate.findOne(query, UserRegistration.class);

        if(userLogin.getUserName().isEmpty()){
            return UserStates.USER_NOT_FOUND;
        } else {
            if(userLogin.getStatus() == LoginStatus.ACTIVE) {

                userLogin.setStatus(LoginStatus.IN_ACTIVE);
                mongoTemplate.save(userLogin);
                return UserStates.USER_SIGNED_OUT;
            }
            return UserStates.USER_FOUND_UNABLE_TO_SIGN_OUT;
        }

    }
}
