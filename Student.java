
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Student extends Person {
    private double cgpa;
    private String major;
    private ArrayList<Course> courses = new ArrayList<>();
    private boolean onProbation;
    private double[] gpas;
    private int semester;
    private double[] semesterGPAs = new double[12]; 
    private String[] completedCourses = new String[20]; 
    private String[] instructors = new String[20];
    private int coursesCovered;

    // Constructor
    public Student(String fullName, int id, int age, float gpa, String email) {
        super(fullName, email, age, id);
        this.cgpa = gpa;
    }

    // Method to Add a Course
    public boolean addCourse(Course course) {
        if (course != null) {
            courses.add(course);
            System.out.println("Course added successfully: " + course.getName());
            return true;
        }
        System.err.println("Error: Course is invalid.");
        return false;
    }

    // Method to Withdraw from a Course
    public boolean withdrawFromCourse(int courseId) {
        boolean removed = courses.removeIf(course -> course.getCourseCode() == courseId);
        if (removed) {
            System.out.println("Course removed successfully!");
            return true;
        }
        System.err.println("Error: Course not found.");
        return false;
    }

    // Method to Calculate GPA
    public double calculateGPA() {
        if (courses.isEmpty()) {
            System.out.println("No courses enrolled. GPA is 0.0");
            return 0.0;
        }
        double totalPoints = 0;
        for (Course course : courses) {
            totalPoints += course.getCredits();
        }
        double gpa = totalPoints / courses.size();
        this.gpas[this.semester - 1] = gpa;
        return gpa;
    }

    public boolean updateSemester(double[] grades) {
        if (grades == null || grades.length == 0) {
            System.out.println("Grades array is empty or null.");
            return false;
        }
        return true;
    }

    

    public Student(String fullName, String address, String phone, String email, int ID, int age, Date dateOfBirth2,
            double cgpa, String major, ArrayList<Student.Course> courses, boolean onProbation, double[] gpas,
            int semester, double[] semesterGPAs, String[] completedCourses, String[] instructors, int coursesCovered) {
        super(fullName, address, phone, email, ID, age, dateOfBirth2);
        this.cgpa = cgpa;
        this.major = major;
        this.courses = courses;
        this.onProbation = onProbation;
        this.gpas = gpas;
        this.semester = semester;
        this.semesterGPAs = semesterGPAs;
        this.completedCourses = completedCourses;
        this.instructors = instructors;
        this.coursesCovered = coursesCovered;
    }

    public Student(String fullName, String email, int ID, int age, double cgpa, String major,
            ArrayList<Student.Course> courses, boolean onProbation, double[] gpas, int semester, double[] semesterGPAs,
            String[] completedCourses, String[] instructors, int coursesCovered) {
        super(fullName, email, ID, age);
        this.cgpa = cgpa;
        this.major = major;
        this.courses = courses;
        this.onProbation = onProbation;
        this.gpas = gpas;
        this.semester = semester;
        this.semesterGPAs = semesterGPAs;
        this.completedCourses = completedCourses;
        this.instructors = instructors;
        this.coursesCovered = coursesCovered;
    }

    public boolean isHonorStudent() {
        return cgpa >= 3.5;
    }

    // Getters & Setters
    public double getCgpa() { return cgpa; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public boolean isOnProbation() { return onProbation; }
    public void setOnProbation(boolean onProbation) { this.onProbation = onProbation; }
    public double[] getGpas() { return gpas; }
    public void setGpas(double[] gpas) { this.gpas = gpas; }
    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }
    public double[] getSemesterGPAs() { return semesterGPAs; }
    public void setSemesterGPAs(double[] semesterGPAs) { this.semesterGPAs = semesterGPAs; }
    public String[] getCompletedCourses() { return completedCourses; }
    public void setCompletedCourses(String[] completedCourses) { this.completedCourses = completedCourses; }
    public String[] getInstructors() { return instructors; }
    public void setInstructors(String[] instructors) { this.instructors = instructors; }
    public int getCoursesCovered() { return coursesCovered; }
    public void setCoursesCovered(int coursesCovered) { this.coursesCovered = coursesCovered; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student ID: ").append(getID()).append("\n");
        sb.append("Name: ").append(getFullName()).append("\n");
        sb.append("Major: ").append(major).append("\n");
        sb.append("CGPA: ").append(cgpa).append("\n");
        sb.append("Semester: ").append(semester).append("\n");
        sb.append("Courses Covered: ").append(courses.size()).append("\n");
        sb.append("Enrolled Courses: ");
        if (courses.isEmpty()) {
            sb.append("None\n");
        } else {
            for (Course course : courses) {
                sb.append(course.getName()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length()).append("\n");
        }
        sb.append("Semester GPAs: ").append(Arrays.toString(semesterGPAs)).append("\n");
        sb.append("Completed Courses: ").append(Arrays.toString(completedCourses)).append("\n");
        sb.append("Instructors: ").append(Arrays.toString(instructors)).append("\n");
        sb.append("On Probation: ").append(onProbation ? "Yes" : "No").append("\n");
        return sb.toString();
    }

    // Inner Class Representing a Course
    public static class Course {
        private String name;
        private int courseCode;
        private int credits;

        public Course(String name, int courseCode, int credits) {
            this.name = name;
            this.courseCode = courseCode;
            this.credits = credits;
        }

        public int getCredits() { return credits; }
        public String getName() { return name; }
        public int getCourseCode() { return courseCode; }
    }
}
