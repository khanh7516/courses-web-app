package com.example.courseapi.database;

import com.example.courseapi.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    public static List<User> userList = new ArrayList<>(List.of(
            new User(1, "A", "abcxyz@gmail.com", "0123", "avar1" ),
            new User(2, "B", "bbcxyz@gmail.com", "2345", "avar2" ),
            new User(3, "C", "cbcxyz@gmail.com", "3456", "avar3" ),
            new User(4, "D", "dbcxyz@gmail.com", "4567", "avar4" ),
            new User(5, "E", "ebcxyz@gmail.com", "5678", "avar5" ),
            new User(6, "F", "fbcxyz@gmail.com", "6789", "avar6" ),
            new User(7, "G", "gbcxyz@gmail.com", "7890", "avar7" )
    ));
}
