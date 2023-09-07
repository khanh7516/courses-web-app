package com.example.courseapi.service;

import com.example.courseapi.dao.CourseDAO;
import com.example.courseapi.dao.UserDAO;
import com.example.courseapi.model.Course;
import com.example.courseapi.model.User;
import com.example.courseapi.request.UpsertCourseRequest;
import com.example.courseapi.response.CourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    private UserDAO userDAO;
    @Override
    public List<Course> getAllCourse(String type, String name, String topic) {
        if (type == null && name == null && topic == null) {
            return courseDAO.findAll();
        }

        List<Course> filteredCourses = new ArrayList<>();

        for (Course course : courseDAO.findAll()) {
            if ((type == null || type.equals(course.getType())) &&
                    (name == null || course.getName().contains(name)) &&
                    (topic == null || course.getTopics().stream().anyMatch(topic::contains))) {
                filteredCourses.add(course);
            }
        }

        return filteredCourses;
    }

    @Override
    public CourseResponse getCourse(Integer id) {
        Course course = courseDAO.findAll().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (course != null) {
            Integer userID = course.getUserId();
            User user = userDAO.getUsers().stream()
                    .filter(c -> c.getId().equals(userID))
                    .findFirst()
                    .orElse(null);
            return new CourseResponse(course, user);
        } else {
            return null;
        }
    }

    @Override
    public List<Course> filterCourses(String type) {
        if("onlab".equals(type)) return getAllOnlabCourses();
        else if("online".equals(type)) return getAllOnlineCourses();
        else return courseDAO.findAll();
    }


    public List<Course> getAllOnlineCourses() {
        List<Course> onlineCourses = new ArrayList<>();
        for (Course course : courseDAO.findAll()) {
            if ("online".equals(course.getType())) {
                onlineCourses.add(course);
            }
        }
        return onlineCourses;
    }

    public List<Course> getAllOnlabCourses() {
        List<Course> onlabCourses = new ArrayList<>();
        for (Course course : courseDAO.findAll()) {
            if ("onlab".equals(course.getType())) {
                onlabCourses.add(course);
            }
        }
        return onlabCourses;
    }


    public Course pushCourse(UpsertCourseRequest upsertCourseRequest) {
        upsertCourseRequest.setId(courseDAO.findAll().get(courseDAO.findAll().size()-1).getId() + 1);
        Course course = new Course(
                upsertCourseRequest.getId(),
                upsertCourseRequest.getName(),
                upsertCourseRequest.getDescription(),
                upsertCourseRequest.getType(),
                upsertCourseRequest.getTopics(),
                upsertCourseRequest.getThumbnail(),
                upsertCourseRequest.getUserId()
        );

        courseDAO.saveCourse(course);
        return course;
    }

    @Override
    public Course updateCourse(Integer id, UpsertCourseRequest course) {
        Optional<Course> foundCourse = courseDAO.findAll().stream().filter(c -> c.getId().equals(id)).findFirst();

        if(foundCourse.isPresent()) {
            Course existCourse = foundCourse.get();

            existCourse.setName(course.getName());
            existCourse.setDescription(course.getDescription());
            existCourse.setType(course.getType());
            existCourse.setTopics(course.getTopics());
            existCourse.setThumbnail(course.getThumbnail());
            existCourse.setUserId(course.getUserId());

            return foundCourse.get();
        }else return null;
    }

    @Override
    public boolean deleteCourse(Integer id) {
        Optional<Course> foundCourse = courseDAO.findAll().stream().filter(c -> c.getId().equals(id)).findFirst();

        if(foundCourse.isPresent()) {
            Course deleteCourse = foundCourse.get();
            courseDAO.findAll().remove(deleteCourse);
            return true;
        }else return false;
    }


}
