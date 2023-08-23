package service.impl;

import data.GlobalData;
import enums.StatusEnum;
import model.Person;
import model.Student;
import service.StudentManagementServiceInter;
import service.StudentServiceInter;

import static util.InputUtil.inputRequiredString;

public class StudentServiceImpl implements StudentServiceInter {
    private static int failedAttempts = 0;
    StudentManagementServiceInter studentManagementServiceInter = new StudentManagementServiceImpl();
    boolean blockStatus = false;

    @Override
    public void seeInfo() {
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student != null) {
                    System.out.println(student.toString());
                } else {
                    System.err.println(StatusEnum.LIST_IS_EMPTY);
                }
            }
        }
    }

    @Override
    public void studentLogIn() {
        String studentUsername = inputRequiredString("Please enter username: ");
        boolean studentExists = false;
        boolean passwordIsCorrect = false;
        boolean isLoggedIn = false;

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
                        }
                        System.err.println(StatusEnum.PASSWORD_IS_NOT_CORRECT);
                        failedAttempts++;

                    }
                    if (!passwordIsCorrect) {
                        blockStatus = true;
                        break;
                    }
                }
            }
        }
        if (!studentExists) {
            System.err.println(StatusEnum.THERE_IS_NO_ANY_PERSON_WITH_THIS_NAME + studentUsername);
            new StudentManagementServiceImpl().studentManagement();
        }
        if (!isLoggedIn && blockStatus) {
            System.err.println(StatusEnum.LOG_IN_DENIED);
            failedAttempts = 0;
            new StudentManagementServiceImpl().studentManagement();
        } else if (!isLoggedIn) {
            System.err.println(StatusEnum.LOG_IN_UNSUCCESSFULLY);
            failedAttempts = 0;
            if (failedAttempts == 3) {
                new StudentManagementServiceImpl().studentManagement();
            }
        }
    }
}