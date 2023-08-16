package service.impl;

import data.GlobalDatas;
import service.TeacherManagementServiceInter;
import service.TeacherServiceInter;

import static util.InputUtil.inputRequiredString;

public class TeacherServiceImpl implements TeacherServiceInter {
    private static int failedAttempts = 0;
    boolean blockStatus = false;
    TeacherManagementServiceInter teacherManagementServiceInter = new TeacherManagementServiceImpl();
    @Override
    public void seeAllClasses() {
        for (int i = 0; i < GlobalDatas.teachersDynamicArray.length; i++) {
            System.out.println(GlobalDatas.teachersDynamicArray[i].getTeacherClass().toString());
        }
    }

    @Override
    public void seeAllTeachers() {
        for (int i = 0; i < GlobalDatas.teachersDynamicArray.length; i++) {
            if (GlobalDatas.teachersDynamicArray != null ) {
                System.out.println(GlobalDatas.teachersDynamicArray[i].toString());
            } else {
                System.err.println("Teacher's List is Empty!");
            }
        }
    }

    @Override
    public void teacherLogIn() {
        String teacherUsername = inputRequiredString("Please enter username: ");
        boolean teacherExists = false;
        boolean passwordIsCorrect = false;

        for (int i = 0; i < GlobalDatas.teachersDynamicArray.length; i++) {
            if (GlobalDatas.teachersDynamicArray[i].getUsername().equals(teacherUsername)) {
                teacherExists = true;
                while (failedAttempts < 3) {
                    String password = inputRequiredString("Please enter password: ");
                    if (GlobalDatas.teachersDynamicArray[i].getPassword().equals(password)) {
                        passwordIsCorrect = true;
                        failedAttempts = 0;

                        this.teacherManagementServiceInter = new TeacherManagementServiceImpl();
                        this.teacherManagementServiceInter.teacherManagement();
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
