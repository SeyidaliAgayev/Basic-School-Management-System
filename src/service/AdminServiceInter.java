package service;

import model.Person;

public interface AdminServiceInter {
    void seeAllTeachersInformation();
    void seeAllStudentsInformation();
    void searchForTeacher();
    void openBlock();
    void addStudent();
    void blockStudent();
    void updateStudent();
    void getStudentById();
    void addTeacher();
    void updateTeacher();
    void deleteTeacherForId();
    void deleteStudentForId();
    void blockTeacher();
    void getTeacherById();
    void searchForStudent();


}
