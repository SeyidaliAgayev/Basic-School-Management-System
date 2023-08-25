package helper;


import enums.ExceptionEnum;
import exceptions.ServiceExceptions;
import model.Student;
import model.Teacher;
import service.AdminManagementServiceInter;
import service.impl.AdminManagementServiceImpl;

import static util.InputUtil.*;


public class ServiceHelper {
    private static int studentId = 0;
    private static int teacherId = 0;
    private static int failedAttempts = 0;
    AdminManagementServiceInter adminManagementServiceInter = new AdminManagementServiceImpl();
    public static Student fillStudent(int i) {
        try {
            System.out.println("------------------\n");
            System.out.println("Student\n");
            String name = inputRequiredString("Name: ");
            String surname = inputRequiredString("Surname: ");
            int age = inputRequiredInt("Age: ");
            if (age < 6) {
                throw new ServiceExceptions(ExceptionEnum.INVALID_STUDENT_AGE);
            }
            String studentClass = inputRequiredString("Student Class: ");
            String email = inputRequiredString("Email: ");
            String password = inputRequiredString("Password: ");
            String username = inputRequiredString("Username: ");

            return new Student(surname,name,age,username,password,++studentId ,email,studentClass);
        } catch (ServiceExceptions exception) {
            System.err.println(exception.getMessage());
        } catch (RuntimeException exception) {
            System.err.println("Wrong Input!");
        }
        return null;
    }
    public static Teacher fillTeacher(int i) {
        try {
            System.out.println("------------------\n");
            System.out.println("Teacher\n");
            String teacherClass = inputRequiredString("Teacher Class: ");
            String name = inputRequiredString("Name: ");
            String surname = inputRequiredString("Surname: ");
            String username = inputRequiredString("Username: ");
            String password = inputRequiredString("Password: ");
            int age = inputRequiredInt("Age: ");
            if (age < 18) {
                throw new ServiceExceptions(ExceptionEnum.INVALID_TEACHER_AGE);
            }
            double salary = inputRequiredDouble("Salary: ");

            return new Teacher(surname,name,age,username,password,salary,++teacherId,teacherClass);
        } catch (ServiceExceptions exception) {
            System.err.println(exception.getMessage());
        } catch (RuntimeException exception) {
            System.err.println("Wrong Input!");
        }
        return null;
    }
}

