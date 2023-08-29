package com.example.courseapi.controller;

import com.example.courseapi.model.Course;
import com.example.courseapi.response.CourseResponse;
import com.example.courseapi.service.CourseService;
import com.example.courseapi.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private TopicService topicService;
    @GetMapping
    public ResponseEntity<List<Course>> getCourses(@RequestParam(value = "type", required = false) String type, @RequestParam(value = "name", required = false) String name,@RequestParam(value = "topic", required = false) String topic ) {
        return ResponseEntity.ok(courseService.getAllCourse(type, name, topic));
    }


    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getCourse (@PathVariable Integer id) {
        return ResponseEntity.ok(courseService.getCourse(id));
    }


    @GetMapping("/topics")
    public ResponseEntity<List<String>> getTopics() {
        return ResponseEntity.ok(topicService.getALlTopics());
    }
}
