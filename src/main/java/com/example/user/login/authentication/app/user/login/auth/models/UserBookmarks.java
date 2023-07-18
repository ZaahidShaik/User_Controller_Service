package com.example.user.login.authentication.app.user.login.auth.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@Document(collection = "PreferenceStore")
@AllArgsConstructor
@NoArgsConstructor
public class UserBookmarks {

    @MongoId
    private String id;

    private String userName;

    private List<String> bookMarks;
}
