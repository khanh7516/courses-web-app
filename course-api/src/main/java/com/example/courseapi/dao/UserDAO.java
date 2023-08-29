package com.example.courseapi.dao;

import com.example.courseapi.database.UserDB;
import com.example.courseapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {

    public List<User> getUsers() {
        return UserDB.userList;
    }
}
