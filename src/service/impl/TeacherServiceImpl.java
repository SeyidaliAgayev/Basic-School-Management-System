package service.impl;

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
    PersonDynamicArrays personDynamicArrays = new PersonDynamicArrayImpl();

    @Override
    public void seeAllClasses() {
        for (int i = 0; i < personDynamicArrays.size(); i++) {
            Person person = personDynamicArrays.get(i);
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                System.out.println(teacher.getTeacherClass().toString());
            }

        }
    }

    @Override
    public void seeAllTeachers() {
        for (int i = 0; i < personDynamicArrays.size(); i++) {
            Person person = personDynamicArrays.get(i);
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

        for (int i = 0; i < personDynamicArrays.size(); i++) {
            Person person = personDynamicArrays.get(i);
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getUsername().equals(teacherUsername)) {
                    teacherExists = true;
                    while (failedAttempts < 3) {
                        String password = inputRequiredString("Please enter password: ");
                        if (teacher.getPassword().equals(password)) {
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
}
