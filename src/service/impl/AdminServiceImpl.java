package service.impl;

import data.GlobalDatas;
import model.Admin;
import model.Student;
import model.Teacher;
import service.AdminManagementServiceInter;
import service.AdminServiceInter;
import service.BaseManagementServiceInter;

import static util.InputUtil.*;
import static helper.ServiceHelper.*;

public class AdminServiceImpl implements AdminServiceInter {
    private static int failedAttempts = 0;
    AdminManagementServiceInter adminManagementServiceInter = new AdminManagementServiceImpl();
    boolean blockStatus = false;
    @Override
    public void searchForTeacher() {
        String teacherName = inputRequiredString("Please enter the teacher's name to search: ");
        for (int i = 0; i < GlobalDatas.teachersDynamicArray.length; i++) {
            if (GlobalDatas.teachersDynamicArray[i].getName().equals(teacherName)) {
                System.out.println(GlobalDatas.teachersDynamicArray[i].toString());
            } else {
                System.err.println("There is no any teacher in this name!");
            }
        }
    }

    @Override
    public void openBlock() {
        blockStatus = false;
    }

    @Override
    public void addStudent() {
        int addStudentCount = inputRequiredInt("How many students will be added: ");
        if (GlobalDatas.studentsDynamicArray == null) {
            GlobalDatas.studentsDynamicArray = new Student[addStudentCount];
            for (int i = 0; i < GlobalDatas.studentsDynamicArray.length; i++) {
                GlobalDatas.studentsDynamicArray[i] = fillStudent(i);
            }
        } else {
            Student[] tempStudents = GlobalDatas.studentsDynamicArray;
            GlobalDatas.studentsDynamicArray = new Student[GlobalDatas.studentsDynamicArray.length + addStudentCount];
            for (int i = 0; i < tempStudents.length; i++) {
                GlobalDatas.studentsDynamicArray[i] = tempStudents[i];
            }
            for (int i = tempStudents.length; i <GlobalDatas.studentsDynamicArray.length ; i++) {
                GlobalDatas.studentsDynamicArray[i] = fillStudent(i);
            }
        }
    }

    @Override
    public void blockStudent() {
        blockStatus = true;
    }

    @Override
    public void updateStudent() {
        String studentName = inputRequiredString("Which student do you want to update: ");
        boolean isUpdated = false;

        for (int i = 0; i < GlobalDatas.studentsDynamicArray.length; i++) {
            if (GlobalDatas.studentsDynamicArray[i].getName().equals(studentName)) {
                String information = inputRequiredString("Which information do you want to change: ");
                String[] parameterString = information.split(",");
                for (String str: parameterString) {
                    switch (str) {
                        case "name":
                            String newStudentName = inputRequiredString("Please enter new student name: ");
                            GlobalDatas.studentsDynamicArray[i].setName(newStudentName);
                            isUpdated = true;
                            break;
                        case "surname":
                            String newStudentSurname = inputRequiredString("Please enter new student surname: ");
                            GlobalDatas.studentsDynamicArray[i].setSurname(newStudentSurname);
                            isUpdated = true;
                            break;
                        case "age":
                            int newStudentAge = inputRequiredInt("Please enter new student age: ");
                            GlobalDatas.studentsDynamicArray[i].setAge(newStudentAge);
                            isUpdated = true;
                            break;
                        case "email":
                            String newStudentEmail = inputRequiredString("Please enter new student email: ");
                            GlobalDatas.studentsDynamicArray[i].setEmail(newStudentEmail);
                            isUpdated = true;
                            break;
                        case "password":
                            String newStudentPassword = inputRequiredString("Please enter the new student password: ");
                            GlobalDatas.studentsDynamicArray[i].setPassword(newStudentPassword);
                            isUpdated = true;
                            break;
                        case "username":
                            String newStudentUsername = inputRequiredString("Please enter new student username: ");
                            GlobalDatas.studentsDynamicArray[i].setUsername(newStudentUsername);
                            isUpdated = true;
                            break;
                        default:
                            System.err.println("Invalid Option!");
                    }
                }
                if (isUpdated) {
                    System.out.println("Student Updated Successfully!");
                }
            }
        }
    }

    @Override
    public Student getStudentById() {
        int studentId = inputRequiredInt("Please enter the student id: ");
        for (int i = 0; i < GlobalDatas.studentsDynamicArray.length; i++) {
            if (GlobalDatas.studentsDynamicArray[i].getId() == studentId) {
                System.out.println(GlobalDatas.studentsDynamicArray[i].toString());
            } else {
                System.err.println("There is no any student in this id number!");
            }
        }
        return new Student(getStudentById().getSurname(), getStudentById().getName(), getStudentById().getAge(),
                getStudentById().getUsername(), getStudentById().getPassword(), getStudentById().getId(),
                getStudentById().getEmail(), getStudentById().getStudentClass());
    }

    @Override
    public void addTeacher() {
        int addTeacherCount = inputRequiredInt("How many teachers will be added: ");
        if (GlobalDatas.teachersDynamicArray == null) {
            GlobalDatas.teachersDynamicArray = new Teacher[addTeacherCount];
            for (int i = 0; i < GlobalDatas.teachersDynamicArray.length; i++) {
                GlobalDatas.teachersDynamicArray[i] = fillTeacher(i);
            }
        } else {
            Teacher[] tempTeachers = GlobalDatas.teachersDynamicArray;
            GlobalDatas.teachersDynamicArray = new Teacher[GlobalDatas.teachersDynamicArray.length + addTeacherCount];
            for (int i = 0; i < tempTeachers.length; i++) {
                GlobalDatas.teachersDynamicArray[i] = tempTeachers[i];
            }
            for (int i = tempTeachers.length; i <GlobalDatas.teachersDynamicArray.length ; i++) {
                GlobalDatas.teachersDynamicArray[i] = fillTeacher(i);
            }
        }
    }

    @Override
    public void updateTeacher() {
        String teacherName = inputRequiredString("Which teacher do you want to update: ");
        boolean isUpdated = false;

        for (int i = 0; i < GlobalDatas.teachersDynamicArray.length; i++) {
            if (GlobalDatas.teachersDynamicArray[i].getName().equals(teacherName)) {
                String information = inputRequiredString("Which information do you want to change: ");
                String[] parameterString = information.split(",");
                for (String str: parameterString) {
                    switch (str) {
                        case "name":
                            String newTeacherName = inputRequiredString("Please enter new teacher name: ");
                            GlobalDatas.teachersDynamicArray[i].setName(newTeacherName);
                            isUpdated = true;
                            break;
                        case "surname":
                            String newTeacherSurname = inputRequiredString("Please enter new teacher surname: ");
                            GlobalDatas.teachersDynamicArray[i].setSurname(newTeacherSurname);
                            isUpdated = true;
                            break;
                        case "age":
                            int newTeacherAge = inputRequiredInt("Please enter new teacher age: ");
                            GlobalDatas.teachersDynamicArray[i].setAge(newTeacherAge);
                            isUpdated = true;
                            break;
                        case "salary":
                            double newTeacherSalary = inputRequiredDouble("Please enter new teacher salary: ");
                            GlobalDatas.teachersDynamicArray[i].setSalary(newTeacherSalary);
                            isUpdated = true;
                            break;
                        default:
                            System.err.println("Invalid Option!");
                    }
                }
                if (isUpdated) {
                    System.out.println("Teacher Updated Successfully!");
                }
            }
        }
    }

    @Override
    public void deleteStudent() {
        Student student = new Student();
        int id = inputRequiredInt("Which student do you want to delete: ");
        for (int i = 0; i < GlobalDatas.studentsDynamicArray.length; i++) {
            if (GlobalDatas.studentsDynamicArray[i].getId() == id) {
                Student[] tempStudent = GlobalDatas.studentsDynamicArray;
                GlobalDatas.studentsDynamicArray = new Student[GlobalDatas.studentsDynamicArray.length - 1];

                for (int j = 0; j < GlobalDatas.studentsDynamicArray.length; j++) {
                    if (tempStudent[i].getId() < student.getId()) {
                        GlobalDatas.studentsDynamicArray[i] = tempStudent[i];
                    } else {
                        GlobalDatas.studentsDynamicArray[i] = tempStudent[i+1];
                    }
                }
            }
        }
        System.out.println("Student Deleted Successfully!");
    }


    @Override
    public void blockTeacher() {
        blockStatus = true;
    }

    @Override
    public Teacher getTeacherById() {
        int teacherId = inputRequiredInt("Please enter teacher's id to search: ");
        for (int i = 0; i < GlobalDatas.teachersDynamicArray.length; i++) {
            if (GlobalDatas.teachersDynamicArray[i].getId() == teacherId) {
                System.out.println(GlobalDatas.teachersDynamicArray[i].toString());
            } else {
                System.err.println("There is no any teacher in this id number!");
            }
        }
        return new Teacher(getTeacherById().getSurname(), getTeacherById().getName(), getTeacherById().getAge(), getTeacherById().getUsername(),
                getTeacherById().getPassword(), getTeacherById().getSalary(), getTeacherById().getId(), getTeacherById().getTeacherClass());
    }

    @Override
    public void searchForStudent() {
        String studentName = inputRequiredString("Please enter student's name to search: ");
        for (int i = 0; i < GlobalDatas.studentsDynamicArray.length; i++) {
            if (GlobalDatas.studentsDynamicArray[i].getName().equals(studentName)) {
                System.out.println(GlobalDatas.studentsDynamicArray[i].toString());
            } else {
                System.err.println("There is no any student in this name!");
            }
        }
    }

    @Override
    public void deleteTeacher() {
        Teacher teacher = new Teacher();
        int id = inputRequiredInt("Which teacher do you want to delete: ");
        for (int i = 0; i < GlobalDatas.teachersDynamicArray.length; i++) {
            if (GlobalDatas.teachersDynamicArray[i].getId() == id) {
                Teacher[] tempTeacher = GlobalDatas.teachersDynamicArray;
                GlobalDatas.teachersDynamicArray = new Teacher[GlobalDatas.teachersDynamicArray.length - 1];

                for (int j = 0; j < GlobalDatas.teachersDynamicArray.length; j++) {
                    if (tempTeacher[i].getId() < teacher.getId()) {
                        GlobalDatas.teachersDynamicArray[i] = tempTeacher[i];
                    } else {
                        GlobalDatas.teachersDynamicArray[i] = tempTeacher[i+1];
                    }
                }
            }
        }
        System.out.println("Teacher Deleted Successfully!");
    }

    @Override
    public void adminLogIn() {
        String adminUsername = inputRequiredString("Please enter username: ");
        boolean adminExists = false;
        boolean passwordIsCorrect = false;
        {
            Admin admin = new Admin("Ali","Ali12345");
                GlobalDatas.adminsDynamicArray[0] = admin;
        }
        for (int i = 0; i < GlobalDatas.adminsDynamicArray.length; i++) {
            if (GlobalDatas.adminsDynamicArray[0].getUsername().equals(adminUsername)) {
                adminExists = true;
                while (failedAttempts < 3) {
                    String password = inputRequiredString("Please enter password: ");
                    if (GlobalDatas.adminsDynamicArray[0].getPassword().equals(password)) {
                        passwordIsCorrect = true;
                        failedAttempts = 0;

                        this.adminManagementServiceInter = new AdminManagementServiceImpl();
                        this.adminManagementServiceInter.adminManagement();
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
