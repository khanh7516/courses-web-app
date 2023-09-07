package com.example.courseapi.service;

import com.example.courseapi.model.Course;
import com.example.courseapi.request.UpsertCourseRequest;
import com.example.courseapi.response.CourseResponse;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse(String type, String name, String topic );
    CourseResponse getCourse(Integer id);

    List<Course> filterCourses(String type);

    Course pushCourse(UpsertCourseRequest course);

    Course updateCourse(Integer id, UpsertCourseRequest course);

    boolean deleteCourse(Integer id);
}
