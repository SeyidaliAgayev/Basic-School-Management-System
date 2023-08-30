package service.impl;

import data.GlobalData;
import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.ServiceExceptions;
import files.impl.FileServiceImpl;
import model.Admin;
import model.Person;
import model.Student;
import model.Teacher;
import service.AdminManagementServiceInter;
import service.AdminServiceInter;
import files.impl.FileServiceImpl.*;

import static helper.UpdateHelper.*;
import static helper.ServiceHelper.*;
import static helper.SearchHelper.*;
import static helper.DeleteHelper.*;
import static helper.ShowInformationHelper.*;


import static util.InputUtil.*;

public class AdminServiceImpl implements AdminServiceInter {
    private static int failedAttempts = 0;
    AdminManagementServiceInter adminManagementServiceInter = new AdminManagementServiceImpl();
    FileServiceImpl fileService = new FileServiceImpl();

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
    public void seeAllTeachersInformation() {
        seeInformation("Teacher");
    }

    @Override
    public void seeAllStudentsInformation() {
        seeInformation("Student");
    }

    @Override
    public void searchForTeacher() {
        personSearchForName("Teacher");
    }
    @Override
    public void addTeacher() {
        int addTeacherCount = inputRequiredInt("How many teachers will be added: ");
        Teacher[] teachers = new Teacher[addTeacherCount];
        for (int i = 0; i < addTeacherCount; i++) {
            teachers[i] = fillTeacher(GlobalData.personDynamicArrays.size() + i);
            GlobalData.personDynamicArrays.add(teachers[i]);
            if (teachers[i] != null) {
                fileService.writeInformation("C:\\Users\\HP\\IdeaProjects\\School-Management-System\\personTeachers.xml", teachers);
            }
        }
    }
    @Override
    public void addStudent() {
        int addStudentCount = inputRequiredInt("How many students will be added: ");
        Student[] students = new Student[addStudentCount];
        for (int i = 0; i < addStudentCount; i++) {
            students[i] = fillStudent(GlobalData.personDynamicArrays.size() + i);
            GlobalData.personDynamicArrays.add(students[i]);
            if (students[i] != null) {
                fileService.writeInformation("C:\\Users\\HP\\IdeaProjects\\School-Management-System\\personStudents.xml", students);
            }
        }

    }

    @Override
    public void deleteTeacherForName() {
        personDeleteForName("Teacher");
    }
    @Override
    public void deleteStudentForName() {
        personDeleteForName("Student");
    }

    @Override
    public void deleteTeacherForId() {
        personDeleteForId("Teacher");
    }

    @Override
    public void deleteStudentForId() {
        personDeleteForId("Student");
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
    public void getStudentById() {
        Person personWithStudents = personSearchForId("Student");
        System.out.println(personWithStudents.toString());
    }

    @Override
    public void getTeacherById() {
        Person personWithTeacher = personSearchForId("Teacher");
        System.out.println(personWithTeacher.toString());
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
                        failedAttempts++;
                        System.err.println("Password is not correct!");
                    }
                    if (!passwordIsCorrect) {
                        blockStatus = true;
                        break;
                    }
                }
            }
        }
        if (!adminExists) {
            new BaseManagementServiceImpl().baseManagement();
            throw new ServiceExceptions(ExceptionEnum.PERSON_NOT_FOUND);
        }
        if (!isLoggedIn && blockStatus) {
            failedAttempts = 0;
            new BaseManagementServiceImpl().baseManagement();
            throw new ServiceExceptions(ExceptionEnum.LOG_IN_DENIED);

        } else if (!isLoggedIn) {
            System.err.println(StatusEnum.LOG_IN_UNSUCCESSFULLY);
            failedAttempts = 0;
            if (failedAttempts == 3) {
                new BaseManagementServiceImpl().baseManagement();
                throw new ServiceExceptions(ExceptionEnum.INCORRECT_PASSWORD);
            }
        }
    }
}

