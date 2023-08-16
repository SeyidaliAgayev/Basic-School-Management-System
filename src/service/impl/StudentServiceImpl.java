package service.impl;

import data.GlobalDatas;
import service.StudentManagementServiceInter;
import service.StudentServiceInter;

import static util.InputUtil.inputRequiredString;

public class StudentServiceImpl implements StudentServiceInter {
    private static int failedAttempts = 0;
    StudentManagementServiceInter studentManagementServiceInter = new StudentManagementServiceImpl();
    boolean blockStatus = false;
    @Override
    public void seeInfo() {
        for (int i = 0; i < GlobalDatas.studentsDynamicArray.length; i++) {
            if (GlobalDatas.studentsDynamicArray != null) {
                System.out.println(GlobalDatas.studentsDynamicArray[i].toString());
            } else {
                System.err.println("Student List is Empty!");
            }
        }
    }

    @Override
    public void studentLogIn() {
        String studentUsername = inputRequiredString("Please enter username: ");
        boolean studentExists = false;
        boolean passwordIsCorrect = false;

        for (int i = 0; i < GlobalDatas.studentsDynamicArray.length; i++) {
            if (GlobalDatas.studentsDynamicArray[i].getUsername().equals(studentUsername)) {
                studentExists = true;
                while (failedAttempts < 3) {
                    String password = inputRequiredString("Please enter password: ");
                    if (GlobalDatas.studentsDynamicArray[i].getPassword().equals(password)) {
                        passwordIsCorrect = true;
                        failedAttempts = 0;

                        this.studentManagementServiceInter = new StudentManagementServiceImpl();
                        this.studentManagementServiceInter.studentManagement();
                    }
                    if (!passwordIsCorrect) {
                        System.err.println("Password is not correct!");
                        failedAttempts++;
                    }
                    if (failedAttempts == 3) {
                        blockStatus = true;
                        break;
                    }
                    if (blockStatus == true) {
                        System.err.println("Log In Denied!");
                    }
                }
            }
        }
    }
}
