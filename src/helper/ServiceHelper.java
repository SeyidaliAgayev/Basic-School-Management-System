package helper;


import model.Student;
import model.Teacher;
import static util.InputUtil.*;

public class ServiceHelper {
    public static Student fillStudent(int i) {
        System.out.println("------------------\n");
        System.out.println(i+1 + ".Student\n");
        int id = inputRequiredInt("Id: ");
        String studentClass = inputRequiredString("Student Class: ");
        String email = inputRequiredString("Email: ");
        String password = inputRequiredString("Password: ");
        String username = inputRequiredString("Username: ");

        return new Student(id,studentClass,email,password,username);
    }
    public static Teacher fillTeacher(int i) {
        System.out.println("------------------\n");
        System.out.println(i+1 + ".Teacher\n");
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
