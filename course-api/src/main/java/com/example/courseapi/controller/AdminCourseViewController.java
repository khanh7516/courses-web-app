package com.example.courseapi.controller;

import com.example.courseapi.dao.UserDAO;
import com.example.courseapi.model.Course;
import com.example.courseapi.response.CourseResponse;
import com.example.courseapi.request.UpsertCourseRequest;
import com.example.courseapi.service.CourseService;
import com.example.courseapi.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Validated
@RequestMapping("/admin/courses")
public class AdminCourseViewController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private UserDAO userDAO;

    @GetMapping
    public String getAllCourses(Model model) {
        List<Course> courseList = courseService.getAllCourse(null, null, null);
        model.addAttribute("courseList", courseList);
        return "admin/course-list";
    }

    @GetMapping("/create")
    public String createCourseForm(Model model) {
        model.addAttribute("topicList", topicService.getALlTopics());
        model.addAttribute("userList", userDAO.getUsers());

        return "admin/create-course";
    }

    @GetMapping("/{id}")
    public String getCourseDetail(Model model, @PathVariable Integer id) {
        CourseResponse courseResponse = courseService.getCourse(id);
        model.addAttribute("courseResponse", courseResponse);
        model.addAttribute("userList", userDAO.getUsers());
        model.addAttribute("topicList", topicService.getALlTopics());

        return "admin/course-detail";
    }


    @PostMapping
    public ResponseEntity<Course> createCourse (@Valid  @RequestBody UpsertCourseRequest upsertCourseRequest) {

        Course newUpsertCourseRequest = courseService.pushCourse(upsertCourseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUpsertCourseRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@Valid @RequestBody UpsertCourseRequest upsertCourseRequest, @PathVariable Integer id) {
        Course updateCourse = courseService.updateCourse(id, upsertCourseRequest);
        if(updateCourse != null) return ResponseEntity.ok(updateCourse);
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        boolean deleted = courseService.deleteCourse(id);

        if(deleted) return ResponseEntity.noContent().build();
        else return ResponseEntity.notFound().build();

    }

}
