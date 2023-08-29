package com.example.courseapi.controller;

import com.example.courseapi.dao.UserDAO;
import com.example.courseapi.model.Course;
import com.example.courseapi.response.CourseResponse;
import com.example.courseapi.service.CourseService;
import com.example.courseapi.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
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
}
