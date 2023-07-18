package com.example.user.login.authentication.app.user.login.auth.repository.UserPreference;

import com.example.user.login.authentication.app.user.login.auth.models.UserBookmarks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarksStoreRepository extends MongoRepository<UserBookmarks, String> {

}
