package com.example.courseapi.dao;

import com.example.courseapi.database.CourseDB;
import com.example.courseapi.model.Course;

import java.util.List;

public interface CourseDAO {
    public List<Course> findAll();
    public void saveCourse(Course course);

}
