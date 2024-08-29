/*
 * @ (#) TestCourse.java       1.0     8/29/2024
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
import java.util.List;
import java.util.Scanner;

public class TestCourse {

    public static void main(String[] args) {
        CourseList courseList = new CourseList();
        initData(courseList);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== Course Management =====");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Remove Course");
            System.out.println("4. Search Course by ID");
            System.out.println("5. Search Course by Title");
            System.out.println("6. Search Course by Department");
            System.out.println("7. Sort Courses by Title");
            System.out.println("8. Find Course(s) with Maximum Credits");
            System.out.println("9. Find Department with Most Courses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCourse(scanner, courseList);
                    break;
                case 2:
                    System.out.println(courseList);
                    break;
                case 3:
                    removeCourse(scanner, courseList);
                    break;
                case 4:
                    searchCourseById(scanner, courseList);
                    break;
                case 5:
                    searchCourseByTitle(scanner, courseList);
                    break;
                case 6:
                    searchCourseByDepartment(scanner, courseList);
                    break;
                case 7:
                    sortCourses(courseList);
                    break;
                case 8:
                    findMaxCreditCourses(courseList);
                    break;
                case 9:
                    findDepartmentWithMostCourses(courseList);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void addCourse(Scanner scanner, CourseList courseList) {
        System.out.print("Enter course ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter course title: ");
        String title = scanner.nextLine();
        System.out.print("Enter course credit: ");
        int credit = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter course department: ");
        String department = scanner.nextLine();

        Course course = new Course(id, title, credit, department);
        courseList.addCourse(course);
    }

    private static void removeCourse(Scanner scanner, CourseList courseList) {
        System.out.print("Enter course ID to remove: ");
        String id = scanner.nextLine();
        courseList.removeCourse(id);
    }

    private static void searchCourseById(Scanner scanner, CourseList courseList) {
        System.out.print("Enter course ID to search: ");
        String id = scanner.nextLine();
        Course course = courseList.searchCourseById(id);
        if (course != null) {
            System.out.println(course);
        } else {
            System.out.println("Course not found.");
        }
    }

    private static void searchCourseByTitle(Scanner scanner, CourseList courseList) {
        System.out.print("Enter course title to search: ");
        String title = scanner.nextLine();
        List<Course> courses = courseList.searchCourseByTitle(title);
        if (courses != null) {
            courses.forEach(System.out::println);
        } else {
            System.out.println("No courses found.");
        }
    }

    private static void searchCourseByDepartment(Scanner scanner, CourseList courseList) {
        System.out.print("Enter course department to search: ");
        String department = scanner.nextLine();
        List<Course> courses = courseList.searchCourseByDepartment(department);
        if (courses != null) {
            courses.forEach(System.out::println);
        } else {
            System.out.println("No courses found.");
        }
    }

    private static void sortCourses(CourseList courseList) {
        List<Course> sortedCourses = courseList.sortCourses();
        sortedCourses.forEach(System.out::println);
    }

    private static void findMaxCreditCourses(CourseList courseList) {
        Course[] courses = courseList.findMaxCreditCourses();
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private static void findDepartmentWithMostCourses(CourseList courseList) {
        String department = courseList.findDepartmentWithMostCourses();
        System.out.println("Department with most courses: " + department);
    }

    private static void initData(CourseList courseList) {
        courseList.addCourse(new Course("420300371101", "Máy học",
                3, "Data Science"));
        courseList.addCourse(new Course("420301412201", "Xử lý ảnh",
                4, "Data Science"));
        courseList.addCourse(new Course("420300126601", "Trí tuệ nhân tạo",
                2, "Data Science"));
        courseList.addCourse(new Course("420301410901", "Tối ưu hóa",
                4, "Data Science"));
    }
}

