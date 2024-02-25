package com.driver;
import java.util.LinkedList;
import java.util.Queue;

public class Course {
    private String courseCode;
    private int availableSeats;
    private Queue<Student> waitingList;

    public Course(String courseCode, int maxSeats) {
        this.courseCode = courseCode;
        this.availableSeats = maxSeats;
        this.waitingList = new LinkedList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public synchronized boolean registerStudent(Student student) {
        if (availableSeats > 0) {
            availableSeats--;
            System.out.println(student.getName() + " registered for " + courseCode);
            return true;
        } else {
            waitingList.offer(student);
            System.out.println(student.getName() + " added to the waiting list for " + courseCode);
            return false;
        }
    }

    public synchronized void processWaitingList() {
        while (!waitingList.isEmpty() && availableSeats > 0) {
            Student student = waitingList.poll();
            availableSeats--;
            System.out.println(student.getName() + " registered from waiting list for " + courseCode);
        }
    }

    public synchronized int getAvailableSeats() {
        return availableSeats;
    }
}