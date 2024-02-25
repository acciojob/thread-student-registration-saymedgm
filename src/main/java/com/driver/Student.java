package com.driver;

public class Student implements Runnable {
    private String name;
    private Course[] courses;

    public Student(String name, Course... courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        for (Course course : courses) {
            boolean registered = course.registerStudent(this);
            if (!registered) {
                // If not registered, student might be added to waiting list.
                course.processWaitingList();
            }
        }
    }
}