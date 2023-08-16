package service;
import model.Student;
import model.Teacher;

public interface AdminServiceInter {
    void searchForTeacher();
    void openBlock();
    void addStudent();
    void blockStudent();
    void updateStudent();
    Student getStudentById();
    void addTeacher();
    void updateTeacher();
    void deleteStudent();
    void blockTeacher();
    Teacher getTeacherById();
    void searchForStudent();
    void deleteTeacher();
    void adminLogIn();

}
