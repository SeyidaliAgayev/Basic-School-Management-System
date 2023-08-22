package service.impl;

import data.GlobalData;
import data.PersonDynamicArrays;
import data.impl.PersonDynamicArrayImpl;
import model.Person;
import model.Teacher;
import service.TeacherManagementServiceInter;
import service.TeacherServiceInter;

import static util.InputUtil.inputRequiredString;

public class TeacherServiceImpl implements TeacherServiceInter {
    private static int failedAttempts = 0;
    boolean blockStatus = false;
    TeacherManagementServiceInter teacherManagementServiceInter = new TeacherManagementServiceImpl();

    @Override
    public void seeAllClasses() {
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                System.out.println(teacher.getTeacherClass().toString());
            }

        }
    }

    @Override
    public void seeAllTeachers() {
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher != null) {
                    System.out.println(teacher.toString());
                } else {
                    System.err.println("Student List is Empty!");
                }
            }
        }
    }

    @Override
    public void teacherLogIn() {
        String teacherUsername = inputRequiredString("Please enter username: ");
        boolean teacherExists = false;
        boolean passwordIsCorrect = false;
        boolean isLoggedIn = false;

        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getUsername().equals(teacherUsername)) {
                    teacherExists = true;
                    while (failedAttempts < 3) {
                        String password = inputRequiredString("Please enter password: ");
                        if (teacher.getPassword().equals(password)) {
                            passwordIsCorrect = true;
                            isLoggedIn = true;
                            failedAttempts = 0;
                            this.teacherManagementServiceInter = new TeacherManagementServiceImpl();
                            this.teacherManagementServiceInter.teacherManagement();
                            System.out.println("Log In Successfully!");
                        }
                        System.err.println("Password is not correct!");
                        failedAttempts++;
                    }
                    if (!passwordIsCorrect) {
                        blockStatus = true;
                        break;
                    }
                }
            }
        }
        if (!teacherExists) {
            System.err.println("There is no any teacher in this username: " + teacherUsername);
        }
        if (!isLoggedIn && blockStatus) {
            System.err.println("Log In Denied!");
            failedAttempts = 0;
            new TeacherManagementServiceImpl().teacherManagement();
        } else if (!isLoggedIn) {
            System.err.println("Log In Unsuccessfully!");
            failedAttempts = 0;
            if (failedAttempts == 3) {
                new TeacherManagementServiceImpl().teacherManagement();
            }
        }
    }
}
