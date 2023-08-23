package service.impl;

import data.GlobalData;
import enums.StatusEnum;
import model.Admin;
import model.Person;
import model.Student;
import model.Teacher;
import service.AdminManagementServiceInter;
import service.AdminServiceInter;

import static helper.UpdateHelper.*;
import static helper.ServiceHelper.*;
import static helper.SearchHelper.*;
import static helper.DeleteHelper.*;


import static util.InputUtil.*;

public class AdminServiceImpl implements AdminServiceInter {
    private static int failedAttempts = 0;
    AdminManagementServiceInter adminManagementServiceInter = new AdminManagementServiceImpl();

    boolean blockStatus = false;
    @Override
    public void updateStudent() {
        personUpdate("Student");
    }
    @Override
    public void updateTeacher() {
        personUpdate("Teacher");
    }
    @Override
    public void searchForStudent() {
        personSearchForName("Student");
    }

    @Override
    public void searchForTeacher() {
        personSearchForName("Teacher");
    }
    @Override
    public void addTeacher() {
        int addTeacherCount = inputRequiredInt("How many teachers will be added: ");
        for (int i = 0; i < addTeacherCount; i++) {
            Teacher newTeachers = fillTeacher(GlobalData.personDynamicArrays.size() + i);
            GlobalData.personDynamicArrays.add(newTeachers);
        }
    }
    @Override
    public void addStudent() {
        int addStudentCount = inputRequiredInt("How many students will be added: ");
        for (int i = 0; i < addStudentCount; i++) {
            Student newStudent = fillStudent(GlobalData.personDynamicArrays.size() + i);
            GlobalData.personDynamicArrays.add(newStudent);
        }
    }

    @Override
    public void deleteTeacher() {
        personDelete("Teacher");
    }
    @Override
    public void deleteStudent() {
        personDelete("Student");
    }
    @Override
    public void blockTeacher() {
        blockStatus = true;
    }
    @Override
    public void openBlock() {
        blockStatus = false;
    }
    @Override
    public void blockStudent() {
        blockStatus = true;
    }
    @Override
    public Student getStudentById() {
        personSearchForId("Student");
        return new Student(getStudentById().getSurname(), getStudentById().getName(), getStudentById().getAge(),
                getStudentById().getUsername(), getStudentById().getPassword(), getStudentById().getId(),
                getStudentById().getEmail(), getStudentById().getStudentClass());
    }

    @Override
    public Teacher getTeacherById() {
        personSearchForId("Teacher");
        return new Teacher(getTeacherById().getSurname(), getTeacherById().getName(), getTeacherById().getAge(), getTeacherById().getUsername(),
                getTeacherById().getPassword(), getTeacherById().getSalary(), getTeacherById().getId(), getTeacherById().getTeacherClass());
    }

    @Override
    public void adminLogIn() {
        String adminUsername = inputRequiredString("Please enter username: ");
        boolean adminExists = false;
        boolean passwordIsCorrect = false;
        boolean isLoggedIn = false;

        {
            Admin admin = new Admin("Ali", "Ali12345");
            GlobalData.personDynamicArrays.add(admin);
        }

        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (person instanceof Admin) {
                Admin admin = (Admin) person;
                if (admin.getUsername().equals(adminUsername)) {
                    adminExists = true;
                    while (failedAttempts < 3) {
                        String password = inputRequiredString("Please enter password: ");
                        if (admin.getPassword().equals(password)) {
                            passwordIsCorrect = true;
                            isLoggedIn = true;
                            failedAttempts = 0;
                            this.adminManagementServiceInter = new AdminManagementServiceImpl();
                            this.adminManagementServiceInter.adminManagement();
                            System.out.println(StatusEnum.LOG_IN_SUCCESSFULLY);
                            break;
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
        if (!adminExists) {
            System.err.println(StatusEnum.THERE_IS_NO_ANY_PERSON_WITH_THIS_NAME + ": " + adminUsername);
            new BaseManagementServiceImpl().baseManagement();
        }
        if (!isLoggedIn && blockStatus) {
            System.err.println(StatusEnum.LOG_IN_DENIED);
            failedAttempts = 0;
            new BaseManagementServiceImpl().baseManagement();

        } else if (!isLoggedIn) {
            System.err.println(StatusEnum.LOG_IN_UNSUCCESSFULLY);
            failedAttempts = 0;
            if (failedAttempts == 3) {
                new BaseManagementServiceImpl().baseManagement();
            }
        }
    }
}

