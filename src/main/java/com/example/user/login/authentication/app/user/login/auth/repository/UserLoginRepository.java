package com.example.user.login.authentication.app.user.login.auth.repository;

import com.example.user.login.authentication.app.user.login.auth.models.UserLogin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends MongoRepository<UserLogin, String> {
}
