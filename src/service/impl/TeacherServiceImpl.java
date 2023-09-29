package service.impl;

import classes.Classes;
import data.GlobalData;
import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.ServiceExceptions;
import files.impl.FileServiceImpl;
import model.Person;
import model.Student;
import model.Teacher;
import service.TeacherManagementServiceInter;
import service.TeacherServiceInter;

import java.io.File;

import static util.InputUtil.inputRequiredString;

public class TeacherServiceImpl implements TeacherServiceInter {
    private static TeacherServiceImpl instance = null;
    private TeacherServiceImpl() {

    }

    public static TeacherServiceImpl getInstance() {
        return instance == null ? new TeacherServiceImpl() : instance;
    }

    @Override
    public void seeAllClasses() {
        for (int i = 0; i < GlobalData.classesDynamicArray.size(); i++) {
            Classes classes = GlobalData.classesDynamicArray.get(i);
            System.out.println(classes.getName());
            for (int j = 0; j < classes.getStudentsDynamicArray().size(); j++) {
                Student student = (Student) classes.getStudentsDynamicArray().get(j);
                System.out.println(student);
            }
        }
    }

    @Override
    public void seeAllTeachers() {
        String teacherUsername = inputRequiredString("Please enter username: ");
        String teacherPassword = inputRequiredString("Please enter password: ");
        boolean teacherFound = false;

        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher != null && teacher.getUsername().equals(teacherUsername) && teacher.getPassword().equals(teacherPassword)) {
                    teacherFound = true;
                    System.out.println(teacher.toString());
                }
            }
        }
        if (!teacherFound) {
            throw new ServiceExceptions(ExceptionEnum.EMPTY_LIST);
        }
    }

    @Override
    public Person teacherLogIn() {
        if (GlobalData.personDynamicArrays.size() == 0 || GlobalData.personDynamicArrays == null) {
            throw new ServiceExceptions(ExceptionEnum.EMPTY_LIST);
        }
        String username = inputRequiredString("Please insert username: ");
        boolean isFound = false;
        boolean isLoggedIn = false;
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getUsername().equals(username)) {
                    isFound = true;
                    if (teacher.isBlocked() == false) {
                        for (int j = 0; j < 3; j++) {
                            String password = inputRequiredString("Please insert password: ");
                            if (teacher.getPassword().equals(password)) {
                                isLoggedIn = true;
                                FileServiceImpl.getInstance().operationHistory(teacher.getUsername(), "Logged in");
                                TeacherManagementServiceImpl.getInstance().teacherManagement();
                                return teacher;
                            } else {
                                System.err.println("Password is not correct!");
                            }
                            if (j == 2) {
                                teacher.blockTeacher();
                                FileServiceImpl.getInstance().operationHistory(teacher.getUsername(), "Has been blocked!");
                                BaseManagementServiceImpl.getInstance().baseManagement();
                            }
                        }
                    }
                    else {
                        System.err.println("You have been blocked please contact with admin!");
                    }
                }
            }
        }
        if (!isLoggedIn) {
            throw new ServiceExceptions(ExceptionEnum.LOG_IN_DENIED);
        }
        return null;
    }
}
