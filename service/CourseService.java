package service;


import model.Course;
import model.person.Faculty;
import model.person.Student;


import java.util.ArrayList;
import java.util.Optional;


public class CourseService
{
   private static final ArrayList<Course> courses = new ArrayList<Course>();
   private CourseService()
   {


   }
   public static  void AddCourse(Course course)
   {
       courses.add(course);
   }
   public static  void AddCourse(String title, String description, int courseCode, int credits, int CRN, char passingGrade, ArrayList<Course> prerequisites, ArrayList<Student> students, Faculty teacher)
   {
       Course newC = new Course(title, description, courseCode, credits, CRN, passingGrade, prerequisites,  students, teacher);
       courses.add(newC);
   }
   public static  void RemoveCourse(int id)
   {
       courses.removeIf(c -> c.getCourseCode() == id);
   }
   public static  Course GetCourse(int id)
   {
       for (Course course : courses) {
           if (course.getCourseCode() == id) {
               return course;
           }
       }
       return null;
   }
   public static  void UpdateCourse(Course course)
   {
       for (int i = 0; i < courses.size(); i++) {
           if (courses.get(i).getCourseCode() == course.getCourseCode()) {
               courses.set(i, course);
               break;
           }
       }
   }
   public static  void AddPrepequisiteToCourse(int courseId, int prerCourseId)
   {
       Course newC = GetCourse(courseId);
       Course prepC = GetCourse(prerCourseId);
       newC.getPrerequisites().add(prepC);
   }
   public static  void AddStudentToCourse(int courseId, int studentId)
   {


   }


}



