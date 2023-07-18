package com.example.user.login.authentication.app.user.login.auth.service.ValidationService;

import com.example.user.login.authentication.app.user.login.auth.models.UserBookmarks;
import com.example.user.login.authentication.app.user.login.auth.models.UserLogin;
import com.example.user.login.authentication.app.user.login.auth.models.UserRegistration;
import com.example.user.login.authentication.app.user.login.auth.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Boolean isUserDetailsValid(final UserLogin user) {
        return null;
    }

    @Override
    public Boolean isUserLoginValid(final UserLogin user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(user.getUserName()).and("password").is(user.getPassword()));
        return mongoTemplate.exists(query, UserRegistration.class);

    }

    @Override
    public Boolean isUserNameLegal(final String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(username));
        return mongoTemplate.exists(query, UserRegistration.class);
    }
}
