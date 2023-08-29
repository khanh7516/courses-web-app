package com.example.courseapi.database;

import com.example.courseapi.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDB {
    public static List<Course> courseList = new ArrayList<>(List.of(
            new Course(1, "Flutter", "ABC", "online",List.of("mobile", "basic") ,"thum1",2 ),
            new Course(2, "Spring", "ABC", "onlab",List.of("backend", "web") ,"thum2",6 ),
            new Course(3, "Js", "ABC", "online",List.of("backend", "frontend", "web", "basic") ,"thum3",5 ),
            new Course(4, "CSS", "ABC", "onlab",List.of("web","frontend", "basic") ,"thum4",3 ),
            new Course(5, "Golang", "ABC", "online",List.of("backend", "web") ,"thum5",5 ),
            new Course(6, "D&A", "ABC", "onlab",List.of("backend") ,"thum6",2 ),
            new Course(7, "Devops", "ABC", "online",List.of("devops", "backend", "web") ,"thum7",5 ),
            new Course(8, "MySQL", "ABC", "onlab",List.of("backend", "database") ,"thum8",7 ),
            new Course(9, "HTML", "ABC", "online",List.of("frontend", "web", "basic") ,"thum9",6 ),
            new Course(10, "Java", "ABC", "onlab",List.of("backend", "basic") ,"thum10",4 ),
            new Course(11, "React", "ABC", "online",List.of("frontend", "web") ,"thum11",4 ),
            new Course(12, "AWS", "ABC", "onlab",List.of("backend", "cloud", "database", "web") ,"thum12",3 ),
            new Course(13, "Switch", "ABC", "onlab",List.of("mobile", "basic") ,"thum13",1 ),
            new Course(14, "Oracle", "ABC", "online",List.of("backend", "database") ,"thum14",2 )
    ));

}
