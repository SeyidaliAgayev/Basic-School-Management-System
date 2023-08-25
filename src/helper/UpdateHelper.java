package helper;

import data.GlobalData;
import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.ServiceExceptions;
import model.Person;
import model.Student;
import model.Teacher;

import static util.InputUtil.*;

public class UpdateHelper {
    public static void personUpdate(String personType) {
        String personName = inputRequiredString("Which student/teacher do you want to update: ");
        boolean isUpdated = false;

        if (GlobalData.personDynamicArrays == null && GlobalData.personDynamicArrays.size() == 0) {
            throw new ServiceExceptions(ExceptionEnum.EMPTY_LIST);
        }

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
                                break;
                            case "surname":
                                String newStudentSurname = inputRequiredString("Please enter new student surname: ");
                                student.setSurname(newStudentSurname);
                                isUpdated = true;
                                break;
                            case "age":
                                int newStudentAge = inputRequiredInt("Please enter new student age: ");
                                student.setAge(newStudentAge);
                                isUpdated = true;
                                break;
                            case "email":
                                String newStudentEmail = inputRequiredString("Please enter new student email: ");
                                student.setEmail(newStudentEmail);
                                isUpdated = true;
                                break;
                            case "password":
                                String newStudentPassword = inputRequiredString("Please enter the new student password: ");
                                student.setPassword(newStudentPassword);
                                isUpdated = true;
                                break;
                            case "username":
                                String newStudentUsername = inputRequiredString("Please enter new student username: ");
                                student.setUsername(newStudentUsername);
                                isUpdated = true;
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
                                break;
                            case "surname":
                                String newTeacherSurname = inputRequiredString("Please enter new teacher surname: ");
                                teacher.setSurname(newTeacherSurname);
                                isUpdated = true;
                                break;
                            case "age":
                                int newTeacherAge = inputRequiredInt("Please enter new teacher age: ");
                                teacher.setAge(newTeacherAge);
                                isUpdated = true;
                                break;
                            case "salary":
                                double newTeacherSalary = inputRequiredDouble("Please enter new teacher salary: ");
                                teacher.setSalary(newTeacherSalary);
                                isUpdated = true;
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
