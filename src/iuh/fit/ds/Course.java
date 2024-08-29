/*
 * @ (#) Course.java       1.0     8/29/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package iuh.fit.ds;


/*
 * @description:
 * @author: Tho, Tran Phu
 * @version:    1.0
 * @created:    8/29/2024 7:09 AM
 */
public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;

    public Course() {
    }

    public Course(String id, String title, int credit, String department) {
        if (id == null || id.length() < 3 || !id.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("ID must have at least 3 characters " +
                    "and contain only letters or digits");
        }
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0");
        }

        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCredit() {
        return credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setId(String id) {
        if (id == null || id.length() < 3 || !id.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("ID must have at least 3 characters " +
                    "and contain only letters or digits");
        }
        this.id = id;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    public void setCredit(int credit) {
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0");
        }
        this.credit = credit;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-20s %-15d %-20s", id, title, credit, department);
    }
}

