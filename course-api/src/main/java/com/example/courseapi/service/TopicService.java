package com.example.courseapi.service;

import com.example.courseapi.dao.TopicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicDAO topicDAO;

    public List<String> getALlTopics() {
        return topicDAO.getTopics();
    }
}
