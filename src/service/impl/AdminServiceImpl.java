package service.impl;

import data.GlobalData;
import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.ServiceExceptions;
import files.impl.FileServiceImpl;
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



}

