package com.example.courseapi.controller;


import com.example.courseapi.response.CourseResponse;
import com.example.courseapi.service.CourseService;
import com.example.courseapi.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v2/courses")
public class CourseViewController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private TopicService topicService;

    @GetMapping
    public String getIndex(Model model, @RequestParam(value = "type", required = false) String type) {
        model.addAttribute("courseList", courseService.filterCourses(type));
        model.addAttribute("topicList", topicService.getALlTopics());

        return "course-list.html";
    }

    @GetMapping("/{id}")
    public String getCourse (Model model, @PathVariable Integer id) {
        CourseResponse courseResponse = courseService.getCourse(id);
        model.addAttribute("courseResponse", courseResponse);

        return "detail.html";

    }


}
