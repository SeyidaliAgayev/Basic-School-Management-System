package service.impl;

import data.PersonDynamicArrays;
import data.impl.PersonDynamicArrayImpl;
import model.Admin;
import model.Person;
import model.Student;
import model.Teacher;
import service.AdminManagementServiceInter;
import service.AdminServiceInter;

import static util.InputUtil.*;
import static helper.ServiceHelper.*;

public class AdminServiceImpl implements AdminServiceInter {
    private static int failedAttempts = 0;
    AdminManagementServiceInter adminManagementServiceInter = new AdminManagementServiceImpl();
    PersonDynamicArrays personDynamicArrays = new PersonDynamicArrayImpl();
    boolean blockStatus = false;

    @Override
    public void searchForTeacher() {
        String teacherName = inputRequiredString("Please enter the teacher's name to search: ");
        for (int i = 0; i < personDynamicArrays.size(); i++) {
            Person person = personDynamicArrays.get(i);
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getName().equals(teacherName)) {
                    System.out.println(teacher.toString());
                } else {
                    System.err.println("There is no any teacher in this name!");
                }
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
        for (int i = 0; i < addStudentCount; i++) {
            Student newStudent = fillStudent(personDynamicArrays.size() + i);
            personDynamicArrays.add(newStudent);
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

        for (int i = 0; i < personDynamicArrays.size(); i++) {
            Person person = personDynamicArrays.get(i);

            if (person instanceof Student) {
                Student student = (Student) person;

                if (student.getName().equals(studentName)) {
                    String information = inputRequiredString("Which information do you want to change: ");
                    String[] parameterString = information.split(",");
                    for (String str : parameterString) {
                        switch (str) {
                            case "name":
                                String newStudentName = inputRequiredString("Please enter new student name: ");
                                student.setName(newStudentName);
                                isUpdated = true;
                                break;
                            case "surname":
                                String newStudentSurname = inputRequiredString("Please enter new student surname: ");
                                student.setSurname(newStudentSurname);
                                isUpdated = true;
                                break;
                            case "age":
                                int newStudentAge = inputRequiredInt("Please enter new student age: ");
                                student.setAge(newStudentAge);
                                isUpdated = true;
                                break;
                            case "email":
                                String newStudentEmail = inputRequiredString("Please enter new student email: ");
                                student.setEmail(newStudentEmail);
                                isUpdated = true;
                                break;
                            case "password":
                                String newStudentPassword = inputRequiredString("Please enter the new student password: ");
                                student.setPassword(newStudentPassword);
                                isUpdated = true;
                                break;
                            case "username":
                                String newStudentUsername = inputRequiredString("Please enter new student username: ");
                                student.setUsername(newStudentUsername);
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
    }

    @Override
    public Student getStudentById() {
        int studentId = inputRequiredInt("Please enter the student id: ");

        for (int i = 0; i < personDynamicArrays.size(); i++) {
            Person person = personDynamicArrays.get(i);

            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getId() == studentId) {
                    System.out.println(student.toString());
                } else {
                    System.err.println("There is no any student in this id number!");
                }
            }
        }
        return new Student(getStudentById().getSurname(), getStudentById().getName(), getStudentById().getAge(),
                getStudentById().getUsername(), getStudentById().getPassword(), getStudentById().getId(),
                getStudentById().getEmail(), getStudentById().getStudentClass());
    }

    @Override
    public void addTeacher() {
        int addTeacherCount = inputRequiredInt("How many teachers will be added: ");
        for (int i = 0; i < addTeacherCount; i++) {
            Teacher newTeachers = fillTeacher(personDynamicArrays.size() + i);
            personDynamicArrays.add(newTeachers);
        }
    }

    @Override
    public void updateTeacher() {
        String teacherName = inputRequiredString("Which teacher do you want to update: ");
        boolean isUpdated = false;

        for (int i = 0; i < personDynamicArrays.size(); i++) {
            Person person = personDynamicArrays.get(i);

            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;

                if (teacher.getName().equals(teacherName)) {
                    String information = inputRequiredString("Which information do you want to change: ");
                    String[] parameterString = information.split(",");
                    for (String str : parameterString) {
                        switch (str) {
                            case "name":
                                String newTeacherName = inputRequiredString("Please enter new teacher name: ");
                                teacher.setName(newTeacherName);
                                isUpdated = true;
                                break;
                            case "surname":
                                String newTeacherSurname = inputRequiredString("Please enter new teacher surname: ");
                                teacher.setSurname(newTeacherSurname);
                                isUpdated = true;
                                break;
                            case "age":
                                int newTeacherAge = inputRequiredInt("Please enter new teacher age: ");
                                teacher.setAge(newTeacherAge);
                                isUpdated = true;
                                break;
                            case "salary":
                                double newTeacherSalary = inputRequiredDouble("Please enter new teacher salary: ");
                                teacher.setSalary(newTeacherSalary);
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
    }

    @Override
    public void deleteStudent() {
        int id = inputRequiredInt("Which student do you want to delete: ");

        for (int i = 0; i < personDynamicArrays.size(); i++) {
            Person person = personDynamicArrays.get(i);

            if (person instanceof Student) {
                Student student = (Student) person;

                if (student.getId() == id) {
                    personDynamicArrays.delete(student);
                }
            }
            System.out.println("Student Deleted Successfully!");
        }
    }


    @Override
    public void blockTeacher() {
        blockStatus = true;
    }

    @Override
    public Teacher getTeacherById() {
        int teacherId = inputRequiredInt("Please enter teacher's id to search: ");

        for (int i = 0; i < personDynamicArrays.size(); i++) {
            Person person = personDynamicArrays.get(i);

            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getId() == teacherId) {
                    System.out.println(teacher.toString());
                } else {
                    System.err.println("There is no any teacher in this id number!");
                }
            }
        }
        return new Teacher(getTeacherById().getSurname(), getTeacherById().getName(), getTeacherById().getAge(), getTeacherById().getUsername(),
                getTeacherById().getPassword(), getTeacherById().getSalary(), getTeacherById().getId(), getTeacherById().getTeacherClass());
    }

    @Override
    public void searchForStudent() {
        String studentName = inputRequiredString("Please enter student's name to search: ");
        for (int i = 0; i < personDynamicArrays.size(); i++) {
            Person person = personDynamicArrays.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getName().equals(studentName)) {
                    System.out.println(student.toString());
                } else {
                    System.err.println("There is no any student in this name!");
                }
            }
        }
    }

    @Override
    public void deleteTeacher() {
        int id = inputRequiredInt("Which teacher do you want to delete: ");

        for (int i = 0; i < personDynamicArrays.size(); i++) {
            Person person = personDynamicArrays.get(i);

            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getId() == id) {
                    personDynamicArrays.delete(teacher);
                }
            }
            System.out.println("Teacher Deleted Successfully!");
        }
    }

    @Override
    public void adminLogIn() {
        String adminUsername = inputRequiredString("Please enter username: ");
        boolean adminExists = false;
        boolean passwordIsCorrect = false;
        {
            Admin admin = new Admin("Ali", "Ali12345");
            personDynamicArrays.add(admin);
        }
        for (int i = 0; i < personDynamicArrays.size(); i++) {
            Person person = personDynamicArrays.get(i);
            if (person instanceof Admin) {
                Admin admin = (Admin) person;
                if (admin.getUsername().equals(adminUsername)) {
                    adminExists = true;
                    while (failedAttempts < 3) {
                        String password = inputRequiredString("Please enter password: ");
                        if (admin.getPassword().equals(password)) {
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
}
