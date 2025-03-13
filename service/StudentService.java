package service;


import model.Course;
import model.person.Faculty;
import model.person.Student;


import java.util.ArrayList;


public class StudentService extends Student
{
   public static final ArrayList<Student> students = new ArrayList<Student>();
   public static final ArrayList<Course> courses = new ArrayList<Course>();
   private StudentService()
   {
       
   }
   public static void AddStudent(Student student)
   {
       students.add(student);
   }
   public static void AddStudent(String fullname, int id, int credits, int CRN, char passingGrade, ArrayList<Course> prerequisites, ArrayList<Student> students, Faculty teacher)
   {
       Student newS = new Student(fullname);
       students.add(newS);
   }

   public boolean withdrawFromCourse(int courseId) {
    return courses.removeIf(course -> course.getCourseCode() == courseId);
}

   public boolean getProbation(int GPAs) {
      return GPAs.removeIf( int GPA -> GPAs.getCGPA() == 2)

    } 
   
}
