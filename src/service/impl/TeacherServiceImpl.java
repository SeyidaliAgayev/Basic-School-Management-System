package service.impl;

import data.GlobalData;
import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.ServiceExceptions;
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
                    throw new ServiceExceptions(ExceptionEnum.EMPTY_LIST);
                }
            }
        }
    }

    @Override
    public void teacherLogIn() {
        if (GlobalData.personDynamicArrays.size() == 0 || GlobalData.personDynamicArrays == null) {
            throw new ServiceExceptions(ExceptionEnum.EMPTY_LIST);
        }
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
                            System.out.println(StatusEnum.LOG_IN_SUCCESSFULLY);
                        }
                        failedAttempts++;
                        throw new ServiceExceptions(ExceptionEnum.INCORRECT_PASSWORD);
                    }
                    if (!passwordIsCorrect) {
                        blockStatus = true;
                        break;
                    }
                }
            }
        }
        if (!teacherExists) {
            new TeacherManagementServiceImpl().teacherManagement();
            throw new ServiceExceptions(ExceptionEnum.PERSON_NOT_FOUND);
        }
        if (!isLoggedIn && blockStatus) {
            failedAttempts = 0;
            new TeacherManagementServiceImpl().teacherManagement();
            throw new ServiceExceptions(ExceptionEnum.LOG_IN_DENIED);
        } else if (!isLoggedIn) {
            System.out.println(StatusEnum.LOG_IN_UNSUCCESSFULLY);
            failedAttempts = 0;
            if (failedAttempts == 3) {
                new TeacherManagementServiceImpl().teacherManagement();
            }
        }
    }
}
