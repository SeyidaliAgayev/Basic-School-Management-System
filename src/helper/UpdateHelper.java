package helper;

import data.GlobalData;
import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.ServiceExceptions;
import files.FileServiceInter;
import files.impl.FileServiceImpl;
import model.Person;
import model.Student;
import model.Teacher;

import java.time.LocalDate;

import static util.InputUtil.*;

public class UpdateHelper {
    public static void personUpdate(String personType) {

        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            if (GlobalData.personDynamicArrays.get(i) instanceof Student || GlobalData.personDynamicArrays.get(i) instanceof Teacher) {
                System.out.println(GlobalData.personDynamicArrays.get(i).toString());
            } else {
                throw new ServiceExceptions(ExceptionEnum.EMPTY_LIST);
            }
        }
        String personName = inputRequiredString("Which student/teacher do you want to update: ");
        boolean isUpdated = false;



        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (personType.equals("Student") && person instanceof Student) {
                Student student = (Student) person;

                if (student.getName().equals(personName)) {
                    String information = inputRequiredString("Which information do you want to change: ");
                    String[] parameterString = information.split(",");
                    for (String str : parameterString) {
                        switch (str) {
                            case "name":
                                String newStudentName = inputRequiredString("Please enter new student name: ");
                                student.setName(newStudentName);
                                isUpdated = true;
                                FileServiceImpl.getInstance().operationHistory(student.getUsername(), "Updated in");
                                break;
                            case "surname":
                                String newStudentSurname = inputRequiredString("Please enter new student surname: ");
                                student.setSurname(newStudentSurname);
                                isUpdated = true;
                                FileServiceImpl.getInstance().operationHistory(student.getUsername(), "Updated in");
                                break;
//                            case "age":
//                                LocalDate newStudentAge = inputRequiredInt("Please enter new student age: ");
//                                student.setBirthdate(newStudentAge);
//                                isUpdated = true;
//                                break;
                            case "email":
                                String newStudentEmail = inputRequiredString("Please enter new student email: ");
                                student.setEmail(newStudentEmail);
                                isUpdated = true;
                                FileServiceImpl.getInstance().operationHistory(student.getUsername(), "Updated in");
                                break;
                            case "password":
                                String newStudentPassword = inputRequiredString("Please enter the new student password: ");
                                student.setPassword(newStudentPassword);
                                isUpdated = true;
                                FileServiceImpl.getInstance().operationHistory(student.getUsername(), "Updated in");
                                break;
                            case "username":
                                String newStudentUsername = inputRequiredString("Please enter new student username: ");
                                student.setUsername(newStudentUsername);
                                isUpdated = true;
                                FileServiceImpl.getInstance().operationHistory(student.getUsername(), "Updated in");
                                break;
                            default:
                                throw new ServiceExceptions(ExceptionEnum.INVALID_OPTION);
                        }
                    }
                    if (isUpdated) {
                        System.out.println(StatusEnum.UPDATE_SUCCESSFULLY);
                    }
                }
            }
            if (personType.equals("Teacher") && person instanceof Teacher) {
                Teacher teacher = (Teacher) person;

                if (teacher.getName().equals(personName)) {
                    String information = inputRequiredString("Which information do you want to change: ");
                    String[] parameterString = information.split(",");
                    for (String str : parameterString) {
                        switch (str) {
                            case "name":
                                String newTeacherName = inputRequiredString("Please enter new teacher name: ");
                                teacher.setName(newTeacherName);
                                isUpdated = true;
                                FileServiceImpl.getInstance().operationHistory(teacher.getUsername(), "Updated in");
                                break;
                            case "surname":
                                String newTeacherSurname = inputRequiredString("Please enter new teacher surname: ");
                                teacher.setSurname(newTeacherSurname);
                                isUpdated = true;
                                FileServiceImpl.getInstance().operationHistory(teacher.getUsername(), "Updated in");
                                break;
//                            case "age":
//                                int newTeacherAge = inputRequiredInt("Please enter new teacher age: ");
//                                teacher.setBirthdate(newTeacherAge);
//                                isUpdated = true;
//                                break;
                            case "salary":
                                double newTeacherSalary = inputRequiredDouble("Please enter new teacher salary: ");
                                teacher.setSalary(newTeacherSalary);
                                isUpdated = true;
                                FileServiceImpl.getInstance().operationHistory(teacher.getUsername(), "Updated in");
                                break;
                            default:
                                throw new ServiceExceptions(ExceptionEnum.INVALID_OPTION);
                        }
                    }
                    if (isUpdated) {
                        System.out.println(StatusEnum.UPDATE_SUCCESSFULLY);
                    }
                }
            }
        }
    }
}
