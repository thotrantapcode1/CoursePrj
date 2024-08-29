/*
 * @ (#) CourseList.java       1.0     8/29/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package iuh.fit.ds;


/*
 * @description:
 * @author: Tho, Tran Phu
 * @version:    1.0
 * @created:    8/29/2024 7:10 AM
 */
import java.util.ArrayList;
import java.util.List;

public class CourseList {
    private int count = 0;
    private List<Course> courses;

    public CourseList() {
        this.courses = new ArrayList<>();
    }

    public boolean addCourse(Course course) {
        if (exists(course)) {
            System.out.println("Course ID already exists. Cannot add.");
            return false;
        }
        courses.add(course);
        count++;
        return true;
    }

    public boolean exists(Course course) {
        return courses.stream().anyMatch(c -> c.getId().equals(course.getId()));
    }

    public boolean removeCourse(String id) {
        Course course = searchCourseById(id);
        if (course != null) {
            courses.remove(course);
            count--;
            return true;
        } else {
            System.out.println("Course ID does not exist. Cannot remove.");
            return false;
        }
    }

    public Course searchCourseById(String id) {
        return courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Course> searchCourseByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(course);
            }
        }
        return result.isEmpty() ? null : result;
    }

    public List<Course> searchCourseByDepartment(String department) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getDepartment().equalsIgnoreCase(department)) {
                result.add(course);
            }
        }
        return result.isEmpty() ? null : result;
    }

    public List<Course> sortCourses() {
        List<Course> sortedList = new ArrayList<>(courses);
        sortedList.sort((c1, c2) -> c1.getTitle().compareToIgnoreCase(c2.getTitle()));
        return sortedList;
    }

    public Course[] findMaxCreditCourses() {
        int maxCredit = courses.stream().mapToInt(Course::getCredit).max().orElse(0);
        return courses.stream().filter(c -> c.getCredit() ==
                maxCredit).toArray(Course[]::new);
    }

    public String findDepartmentWithMostCourses() {
        return courses.stream()
                .map(Course::getDepartment)
                .reduce((a, b) -> courses.stream().filter(c ->
                        c.getDepartment().equals(a)).count() >=
                        courses.stream().filter(c -> c.getDepartment().equals(b)).count()
                        ? a : b)
                .orElse(null);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s %-20s %-15s %-20s\n", "ID", "Title",
                "Credit", "Department"));
        for (Course course : courses) {
            sb.append(course.toString()).append("\n");
        }
        return sb.toString();
    }
}

