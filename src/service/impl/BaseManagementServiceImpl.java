package service.impl;

import service.AdminManagementServiceInter;
import service.BaseManagementServiceInter;
import service.StudentManagementServiceInter;
import service.TeacherManagementServiceInter;

import static util.MenuUtil.*;

public class BaseManagementServiceImpl implements BaseManagementServiceInter {
    @Override
    public void baseManagement() {
        while (true) {
            int option = entryMenu();
            switch (option) {
                case 1:
                    StudentManagementServiceInter studentManagementServiceInter = new StudentManagementServiceImpl();
                    studentManagementServiceInter.studentManagement();
                    break;
                case 2:
                    TeacherManagementServiceInter teacherManagementServiceInter = new TeacherManagementServiceImpl();
                    teacherManagementServiceInter.teacherManagement();
                    break;
                case 3:
                    AdminManagementServiceInter adminManagementServiceInter = new AdminManagementServiceImpl();
                    adminManagementServiceInter.adminManagement();
                    break;
                case 0:
                    System.exit(-1);
                default:
                    System.err.println("Invalid Option!");
            }
        }
    }
}
