package service.impl;

import data.PersonDynamicArrays;
import data.impl.PersonDynamicArrayImpl;
import model.Person;
import model.Student;
import service.StudentManagementServiceInter;
import service.StudentServiceInter;

import static util.InputUtil.inputRequiredString;

public class StudentServiceImpl implements StudentServiceInter {
    private static int failedAttempts = 0;
    StudentManagementServiceInter studentManagementServiceInter = new StudentManagementServiceImpl();
    PersonDynamicArrays personDynamicArrays = new PersonDynamicArrayImpl();
    boolean blockStatus = false;

    @Override
    public void seeInfo() {
        for (int i = 0; i < personDynamicArrays.size(); i++) {
            Person person = personDynamicArrays.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student != null) {
                    System.out.println(student.toString());
                } else {
                    System.err.println("Student List is Empty!");
                }
            }
        }
    }

    @Override
    public void studentLogIn() {
        String studentUsername = inputRequiredString("Please enter username: ");
        boolean studentExists = false;
        boolean passwordIsCorrect = false;

        for (int i = 0; i < personDynamicArrays.size(); i++) {
            Person person = personDynamicArrays.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getUsername().equals(studentUsername)) {
                    studentExists = true;
                    while (failedAttempts < 3) {
                        String password = inputRequiredString("Please enter password: ");
                        if (student.getPassword().equals(password)) {
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
}