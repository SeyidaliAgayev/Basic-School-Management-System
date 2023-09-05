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
import service.AdminServiceInter;

import static helper.UpdateHelper.*;
import static helper.ServiceHelper.*;
import static helper.SearchHelper.*;
import static helper.DeleteHelper.*;
import static helper.ShowInformationHelper.*;


import static util.InputUtil.*;

public class AdminServiceImpl implements AdminServiceInter {
    private static AdminServiceImpl instance = null;
    private AdminServiceImpl() {

    }

    public static AdminServiceImpl getInstance() {
        return instance == null ? new AdminServiceImpl() : instance;
    }

    private static int failedAttempts = 0;


    boolean isBlocked = false;
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
        for (int i = 0; i < addTeacherCount; i++) {
            Teacher newTeachers  = fillTeacher(GlobalData.personDynamicArrays.size() + i);
            GlobalData.personDynamicArrays.add(newTeachers);
            if (newTeachers != null) {
                FileServiceImpl.getInstance().writeInformation("persons.txt");
                FileServiceImpl.getInstance().operationHistory(GlobalData.personDynamicArrays.get(i).getUsername(), "Added New Teachers");
            }
        }
    }
    @Override
    public void addStudent() {
        int addStudentCount = inputRequiredInt("How many students will be added: ");
        for (int i = 0; i < addStudentCount; i++) {
            Student newStudents = fillStudent(GlobalData.personDynamicArrays.size() + i);
            GlobalData.personDynamicArrays.add(newStudents);
            if (newStudents != null) {
                FileServiceImpl.getInstance().writeInformation("persons.txt");
                FileServiceImpl.getInstance().operationHistory(GlobalData.personDynamicArrays.get(i).getUsername(), "Added New Students");
            }
        }

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
        int blockTeacherId = inputRequiredInt("Please enter teacher's ID to block: ");
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getId() == blockTeacherId) {
                    teacher.blockTeacher();
                    System.out.println("Teacher with [" + teacher.getId() + "] ID has been blocked!");
                }
            }
        }
    }
    @Override
    public void openBlock() {
        int blockId = inputRequiredInt("Please enter person's ID to unblock: ");
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getId() == blockId) {
                    teacher.unblockTeacher();
                    System.out.println("Teacher with [" + teacher.getId() + "] ID has been unblocked!");
                    FileServiceImpl.getInstance().operationHistory(teacher.getUsername(), "Has been unblocked!");
                    break;
                }
            }
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getId() == blockId) {
                    student.unBlockStudent();
                    System.out.println("Student with [" + student.getId() + "] ID has been unblocked!");
                    FileServiceImpl.getInstance().operationHistory(student.getUsername(), "Has been unblocked!");
                    break;
                }
            }
        }
    }
    @Override
    public void blockStudent() {
        int blockStudentId = inputRequiredInt("Please enter student's ID to block: ");
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getId() == blockStudentId) {
                    student.blockStudent();
                    System.out.println("Student with [" + student.getId() + "] ID has been blocked!");
                }
            }
        }
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
            FileServiceImpl.getInstance().operationHistory(adminUsername, "Logged in");
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
                            AdminManagementServiceImpl.getInstance().adminManagement();
                            System.out.println(StatusEnum.LOG_IN_SUCCESSFULLY);
                            break;
                        }
                        failedAttempts++;
                        System.err.println("Password is not correct!");
                    }
                    if (!passwordIsCorrect) {
                        isBlocked = true;
                        break;
                    }
                }
            }
        }
        if (!adminExists) {
            BaseManagementServiceImpl.getInstance().baseManagement();
            throw new ServiceExceptions(ExceptionEnum.PERSON_NOT_FOUND);
        }
        if (!isLoggedIn && isBlocked) {
            failedAttempts = 0;
            BaseManagementServiceImpl.getInstance().baseManagement();
            throw new ServiceExceptions(ExceptionEnum.LOG_IN_DENIED);

        } else if (!isLoggedIn) {
            System.err.println(StatusEnum.LOG_IN_UNSUCCESSFULLY);
            failedAttempts = 0;
            if (failedAttempts == 3) {
                BaseManagementServiceImpl.getInstance().baseManagement();
                throw new ServiceExceptions(ExceptionEnum.INCORRECT_PASSWORD);
            }
        }
    }
}

