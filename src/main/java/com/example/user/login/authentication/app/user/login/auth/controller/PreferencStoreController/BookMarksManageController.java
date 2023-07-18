package com.example.user.login.authentication.app.user.login.auth.controller.PreferencStoreController;

import com.example.user.login.authentication.app.user.login.auth.models.UserLogin;
import com.example.user.login.authentication.app.user.login.auth.service.PreferenceStoreService.BookmarksManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class BookMarksManageController {

    @Autowired
    private BookmarksManageService bookmarksManageService;

    /**
     * GET : Get All user Bookmarks
     * @param: UserName
     * returns: List of All bookmarks
     **/
    @GetMapping(value = "/{userName}/bookmarks")
    public ResponseEntity<?> getUserBookmarks(@PathVariable("userName") String userName){
        System.out.println(" userName: "+ userName);
        return ResponseEntity.ok(bookmarksManageService.fetchUserBookmarks(userName));
    }


    /**
     * POST : add new Bookmarks
     * @param: UserName
     * @param: Bookmark to add
     * returns: List of All bookmarks
     **/
    @PostMapping(value = "/{userName}/bookmarks/add/{addToBookmark}")
    public ResponseEntity<?> saveUserBookmark(@PathVariable("userName") String userName,
                                              @PathVariable("addToBookmark") String addBookmark){

        System.out.println(" userName: "+ userName);
        System.out.println(" addBookmark: "+ addBookmark);
        return ResponseEntity.ok(bookmarksManageService.addNewBookmark(userName,addBookmark));
    }

    /**
     * POST : delete new Bookmarks
     * @param: UserName
     * @param: Bookmark to remove
     * returns: List of All bookmarks
     **/
    @PostMapping(value = "/{userName}/bookmarks/remove/{removeFromBookmark}")
    public ResponseEntity<?> removeUserBookmark(@PathVariable("userName") String userName,
                                                @PathVariable("removeFromBookmark") String removeBookmark){
        System.out.println(" userName: "+ userName);
        System.out.println(" removeBookmark: "+ removeBookmark);
        return ResponseEntity.ok(bookmarksManageService.removeUserBookmark(userName,removeBookmark));
    }

}
