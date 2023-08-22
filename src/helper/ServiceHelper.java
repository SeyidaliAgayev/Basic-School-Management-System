package helper;


import model.Student;
import model.Teacher;
import static util.InputUtil.*;

public class ServiceHelper {
    public static Student fillStudent(int i) {
        System.out.println("------------------\n");
        System.out.println("Student\n");
        int id = inputRequiredInt("Id: ");
        String name = inputRequiredString("Name: ");
        String surname = inputRequiredString("Surname: ");
        int age = inputRequiredInt("Age: ");
        String studentClass = inputRequiredString("Student Class: ");
        String email = inputRequiredString("Email: ");
        String password = inputRequiredString("Password: ");
        String username = inputRequiredString("Username: ");

        return new Student(surname,name,age,username,password,id ,email,studentClass);
    }
    public static Teacher fillTeacher(int i) {
        System.out.println("------------------\n");
        System.out.println("Teacher\n");
        int id = inputRequiredInt("Id: ");
        String teacherClass = inputRequiredString("Teacher Class: ");
        String name = inputRequiredString("Name: ");
        String surname = inputRequiredString("Surname: ");
        String username = inputRequiredString("Username: ");
        String password = inputRequiredString("Password: ");
        int age = inputRequiredInt("Age: ");
        double salary = inputRequiredDouble("Salary: ");

        return new Teacher(surname,name,age,username,password,salary,id,teacherClass);
    }
}
