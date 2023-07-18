package com.example.user.login.authentication.app.user.login.auth.service.PreferenceStoreService;

import com.example.user.login.authentication.app.user.login.auth.models.UserBookmarks;

import java.util.List;

public interface BookmarksManageService {

    UserBookmarks fetchUserBookmarks(String userName);
    UserBookmarks addNewBookmark(String userName, String addBookmark);
    UserBookmarks removeUserBookmark(String userName, String removeBookmark);
}
