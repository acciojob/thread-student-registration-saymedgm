package com.driver;

public class Student implements Runnable {
    private String name;
    private Course[] courses;

    public Student(String name, Course... courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
    	//your code goes here
        return name;
    }

    @Override
    public void run() {
    	//your code goes here
    }
}
