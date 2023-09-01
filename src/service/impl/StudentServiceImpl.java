package service.impl;

import data.GlobalData;
import data.PersonDynamicArrays;
import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.ServiceExceptions;
import files.impl.FileServiceImpl;
import model.Person;
import model.Student;
import service.StudentManagementServiceInter;
import service.StudentServiceInter;

import static util.InputUtil.inputRequiredString;

public class StudentServiceImpl implements StudentServiceInter {
    private static int failedAttempts = 0;
    StudentManagementServiceInter studentManagementServiceInter = new StudentManagementServiceImpl();
    static FileServiceImpl fileService = new FileServiceImpl();
    boolean blockStatus = false;


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
        boolean studentExists = false;
        boolean passwordIsCorrect = false;
        boolean isLoggedIn = false;
        Student loggedInStudent = null;

        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getUsername().equals(studentUsername)) {
                    studentExists = true;
                    while (failedAttempts < 3) {
                        String password = inputRequiredString("Please enter password: ");
                        if (student.getPassword().equals(password)) {
                            passwordIsCorrect = true;
                            isLoggedIn = true;
                            failedAttempts = 0;
                            this.studentManagementServiceInter = new StudentManagementServiceImpl();
                            this.studentManagementServiceInter.studentManagement();
                            System.out.println(StatusEnum.LOG_IN_SUCCESSFULLY);
                            loggedInStudent = student;
                        }
                        failedAttempts++;

                    }
                    if (!passwordIsCorrect) {
                        blockStatus = true;
                        throw new ServiceExceptions(ExceptionEnum.INCORRECT_PASSWORD);
                    }
                }
            }
        }
        if (!studentExists) {
            new StudentManagementServiceImpl().studentManagement();
            throw new ServiceExceptions(ExceptionEnum.PERSON_NOT_FOUND);
        }
        if (!isLoggedIn && blockStatus) {
            failedAttempts = 0;
            new StudentManagementServiceImpl().studentManagement();
            throw new ServiceExceptions(ExceptionEnum.LOG_IN_DENIED);
        } else if (!isLoggedIn) {
            System.err.println(StatusEnum.LOG_IN_UNSUCCESSFULLY);
            failedAttempts = 0;
            if (failedAttempts == 3) {
                new StudentManagementServiceImpl().studentManagement();
            }
        }
        return loggedInStudent;
    }

}