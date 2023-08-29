package com.example.courseapi.dao;

import com.example.courseapi.database.TopicDB;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopicDAO {
    public List<String> getTopics() {
        return TopicDB.topics;
    }
}
