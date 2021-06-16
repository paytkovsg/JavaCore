package Lesson9.Homework9;

import java.util.ArrayList;
import java.util.List;

public class Student implements Students {
    String name;
    List<Course> courses = new ArrayList<>();

    public Student(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourses(Course course) {
        courses.add(course);
    };

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }
}

