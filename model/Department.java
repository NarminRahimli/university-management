package model;

import java.util.ArrayList;
import model.person.Faculty;
import model.person.Student;

public class Department {
    private int departmentId;
    private String name;
    private ArrayList<Faculty> facultyMembers;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private Faculty headOfDepartment;

    // Constructor
    public Department(int departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
        this.facultyMembers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.headOfDepartment = null;
    }

    // Getter and Setter methods
    public int getDepartmentId() { return departmentId; }
    public String getName() { return name; }
    public Faculty getHeadOfDepartment() { return headOfDepartment; }
    public void setHeadOfDepartment(Faculty headOfDepartment) { this.headOfDepartment = headOfDepartment; }
    public void addFaculty(Faculty faculty) { facultyMembers.add(faculty); }
    public void removeFaculty(Faculty faculty) { facultyMembers.remove(faculty); }
    public void addStudent(Student student) { students.add(student); }
    public void removeStudent(Student student) { students.remove(student); }
    public void addCourse(Course course) { courses.add(course); }
    public void removeCourse(Course course) { courses.remove(course); }

    
    @Override
    public String toString() {
        return "Department ID: " + departmentId + ", Name: " + name +
                ", Head: " + (headOfDepartment != null ? headOfDepartment.getFullName() : "None") +
                ", Faculty Count: " + facultyMembers.size() +
                ", Student Count: " + students.size() +
                ", Courses Offered: " + courses.size();
    }
}

