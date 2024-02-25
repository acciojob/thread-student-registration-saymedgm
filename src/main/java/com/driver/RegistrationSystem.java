package com.driver;

public class RegistrationSystem {
    public static void main(String[] args) {
        Course mathCourse = new Course("MATH101", 3);
        Course historyCourse = new Course("HIST101", 2);

        Student alice = new Student("Alice", mathCourse, historyCourse);
        Student bob = new Student("Bob", mathCourse, historyCourse);
        Student charlie = new Student("Charlie", mathCourse, historyCourse);
        Student david = new Student("David", mathCourse, historyCourse);
        Student eve = new Student("Eve", mathCourse, historyCourse);

        // Simulating concurrent registration by starting multiple threads
        Thread thread1 = new Thread(alice);
        Thread thread2 = new Thread(bob);
        Thread thread3 = new Thread(charlie);
        Thread thread4 = new Thread(david);
        Thread thread5 = new Thread(eve);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        // Wait for all threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final state of courses
        System.out.println("\nFinal state of courses:");
        System.out.println("Math Course - Available Seats: " + mathCourse.getAvailableSeats());
        System.out.println("History Course - Available Seats: " + historyCourse.getAvailableSeats());
    }
}
