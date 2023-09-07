package com.example.courseapi.dao;

import com.example.courseapi.database.CourseDB;
import com.example.courseapi.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO {
    public List<Course> findAll() {
        return CourseDB.courseList;
    }

    public void  saveCourse(Course course) {
        CourseDB.courseList.add(course);
    }
}
