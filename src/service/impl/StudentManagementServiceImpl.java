package service.impl;

import service.StudentManagementServiceInter;
import service.StudentServiceInter;
import static util.MenuUtil.*;

public class StudentManagementServiceImpl implements StudentManagementServiceInter {
    @Override
    public void studentManagement() {
        StudentServiceInter studentServiceInter = new StudentServiceImpl();
        while (true) {
            int option = studentMenu();
            switch (option) {
                case 1:
                    studentServiceInter.studentLogIn();
                    break;
                case 2:
                    studentServiceInter.seeInfo();
                    break;
                case 0:
                    System.exit(-1);
                default:
                    System.err.println("Invalid Option!");
            }
        }
    }
}
