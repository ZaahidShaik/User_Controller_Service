package com.example.user.login.authentication.app.user.login.auth.service.PreferenceStoreService;

import com.example.user.login.authentication.app.user.login.auth.models.UserBookmarks;
import com.example.user.login.authentication.app.user.login.auth.repository.UserPreference.BookmarksStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookmarksManageServiceImpl implements BookmarksManageService {

    @Autowired
    private BookmarksStoreRepository bookmarksStoreRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public UserBookmarks fetchUserBookmarks(String userName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(userName));
//        if(mongoTemplate.exists(query, UserBookmarks.class)){
           return mongoTemplate.findOne(query, UserBookmarks.class) ;
//        }
//        return ;
    }

    @Override
    public UserBookmarks addNewBookmark(String userName, String addBookmark) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(userName));
//        System.out.println(mongoTemplate.exists(query, UserBookmarks.class));
        if(mongoTemplate.exists(query, UserBookmarks.class)){
            UserBookmarks userBookMarks = mongoTemplate.findOne(query, UserBookmarks.class);
            if (userBookMarks != null) {
                /**
                 * Add another condition to check if the country already is bookmarked list.
                 * a.k.a search the bookmark list for that value.
                 * */
                userBookMarks.getBookMarks().add(addBookmark);
                Collections.sort(userBookMarks.getBookMarks());
                mongoTemplate.save(userBookMarks);
            }

        }else {
            addFirstBookmark(userName, addBookmark);
        }
        return mongoTemplate.findOne(query, UserBookmarks.class);
    }

    @Override
    public UserBookmarks removeUserBookmark(String userName, String removeBookmark) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(userName));
        if(mongoTemplate.exists(query, UserBookmarks.class)) {
            UserBookmarks userBookMarks = mongoTemplate.findOne(query, UserBookmarks.class);
            if (userBookMarks != null) {
                userBookMarks.getBookMarks().remove(removeBookmark);
                Collections.sort(userBookMarks.getBookMarks());
                mongoTemplate.save(userBookMarks);
            }
        }
        return mongoTemplate.findOne(query, UserBookmarks.class);
    }

    private void addFirstBookmark(String userName, String addBookmark){
        UserBookmarks userBookMarks = new UserBookmarks();
        userBookMarks.setUserName(userName);
        userBookMarks.setBookMarks(List.of(addBookmark));
        bookmarksStoreRepository.save(userBookMarks);

        mongoTemplate.save(userBookMarks);
    }


}
