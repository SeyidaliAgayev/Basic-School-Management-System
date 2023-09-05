package service.impl;

import data.GlobalData;
import enums.ExceptionEnum;
import exceptions.ServiceExceptions;
import files.impl.FileServiceImpl;
import model.Person;
import model.Student;
import service.StudentServiceInter;

import java.io.File;

import static util.InputUtil.inputRequiredString;

public class StudentServiceImpl implements StudentServiceInter {
    private static StudentServiceImpl instance = null;
    private StudentServiceImpl() {

    }

    public static StudentServiceImpl getInstance() {
        return instance == null ? new StudentServiceImpl() : instance;
    }

    private static int failedAttempts = 0;

    boolean isFound = false;



    @Override
    public void seeInfo() {
        String studentUsername = inputRequiredString("Please enter username: ");
        String studentPassword = inputRequiredString("Please enter password: ");
        boolean studentFound = false;
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student != null && student.getUsername().equals(studentUsername) && student.getPassword().equals(studentPassword)) {
                    studentFound = true;
                    System.out.println(student.toString());
                }
            }
        }
        if (!studentFound) {
            throw new ServiceExceptions(ExceptionEnum.EMPTY_LIST);
        }
    }
    @Override
    public Person studentLogIn() {
        String studentUsername = inputRequiredString("Please enter username: ");
        boolean isLoggedIn = false;
        boolean isFound = false; // Initialize isFound

        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getUsername().equals(studentUsername)) {
                    isFound = true;
                    if (!student.isBlocked()) {
                        for (int j = 0; j < 3; j++) {
                            String studentPassword = inputRequiredString("Please enter password: ");
                            if (studentPassword.equals(student.getPassword())) {
                                isLoggedIn = true;
                                FileServiceImpl.getInstance().operationHistory(studentUsername, "Logged in");
                                StudentManagementServiceImpl.getInstance().studentManagement();
                                return student;
                            } else {
                                System.err.println("Password is not correct!");
                            }
                            if (j == 2) {
                                student.blockStudent();
                                FileServiceImpl.getInstance().operationHistory(studentUsername, "Has been blocked!");
                                BaseManagementServiceImpl.getInstance().baseManagement();
                            }
                        }
                    } else {
                        System.err.println("You have been blocked please contact with admin");
                    }
                }
            }
        }

        // Move the exception handling outside of the loop
        if (!isLoggedIn) {
            throw new ServiceExceptions(ExceptionEnum.LOG_IN_DENIED);
        }

        if (!isFound) {
            throw new ServiceExceptions(ExceptionEnum.PERSON_NOT_FOUND);
        }
        return null;
    }

}
//@Override
//    public Person studentLogIn() {
//        String studentUsername = inputRequiredString("Please enter username: ");
//        boolean isLoggedIn = false;
//
//        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
//            Person person = GlobalData.personDynamicArrays.get(i);
//            if (person instanceof Student) {
//                Student student = (Student) person;
//                if (student.getUsername().equals(studentUsername)) {
//                    isFound = true;
//                    if (student.isBlocked() == false) {
//                        for(int j = 0; j < 3; j++) {
//                            String studentPassword = inputRequiredString("Please enter password: ");
//                            if (studentPassword.equals(student.getPassword())) {
//                                isLoggedIn = true;
//                                FileServiceImpl.getInstance().operationHistory(studentUsername, "Logged in");
//                                StudentManagementServiceImpl.getInstance().studentManagement();
//                                return student;
//                            } else {
//                                System.err.println("Password is not correct!");
//                            }
//                            if (j == 2) {
//                                student.blockStudent();
//                                FileServiceImpl.getInstance().operationHistory(studentUsername, "Has been blocked!");
//                                BaseManagementServiceImpl.getInstance().baseManagement();
//                            }
//                        }
//                    }
//                    else {
//                        System.err.println("You have been blocked please contact with admin");
//                    }
//                }
//                if (!isLoggedIn) {
//                    throw new ServiceExceptions(ExceptionEnum.LOG_IN_DENIED);
//                }
//            }
//        }
//        if (!isFound) {
//            throw new ServiceExceptions(ExceptionEnum.PERSON_NOT_FOUND);
//        }
//        return null;
//    }
