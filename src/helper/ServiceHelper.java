package helper;


import enums.ExceptionEnum;
import exceptions.ServiceExceptions;
import model.Student;
import model.Teacher;
import service.AdminManagementServiceInter;
import service.impl.AdminManagementServiceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

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
            LocalDate studentBirthDate = birthdateHelper();
            Period period = Period.between(studentBirthDate, LocalDate.now());
            if (period.getYears() < 6) {
                throw new ServiceExceptions(ExceptionEnum.INVALID_STUDENT_AGE);
            }
            String studentClass = inputRequiredString("Student Class: ");
            String email = inputRequiredString("Email: ");
            String password = inputRequiredString("Password: ");
            String username = inputRequiredString("Username: ");

            return new Student(surname,name,studentBirthDate,username,password,++studentId ,email,studentClass);
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

            LocalDate teacherBirthDate = birthdateHelper();
            Period period = Period.between(teacherBirthDate, LocalDate.now());
            if (period.getYears() < 18) {
                throw new ServiceExceptions(ExceptionEnum.INVALID_TEACHER_AGE);
            }

            double salary = inputRequiredDouble("Salary: ");

            return new Teacher(surname,name,teacherBirthDate,username,password,salary,++teacherId,teacherClass);
        } catch (ServiceExceptions exception) {
            System.err.println(exception.getMessage());
        } catch (RuntimeException exception) {
            System.err.println("Wrong Input!");
        }
        return null;
    }
    public static LocalDate birthdateHelper() {
        String birthDate =  inputRequiredString("Enter birthdate(year/month/day) : ");
        String[] newBirthDate = birthDate.split("/");
        int years = Integer.parseInt(newBirthDate[0]);
        int month = Integer.parseInt(newBirthDate[1]);
        int day = Integer.parseInt(newBirthDate[2]);

        return LocalDate.of(years,month,day);
    }

}

