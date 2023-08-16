package service.impl;

import service.AdminManagementServiceInter;
import service.AdminServiceInter;
import static util.MenuUtil.*;


public class AdminManagementServiceImpl implements AdminManagementServiceInter {
    @Override
    public void adminManagement() {
        AdminServiceInter adminServiceInter = new AdminServiceImpl();
        while (true) {
            int option = adminMenu();
            switch (option) {
                case 1:
                    adminServiceInter.addStudent();
                    break;
                case 2:
                    adminServiceInter.addTeacher();
                    break;
                case 3:
                    adminServiceInter.deleteStudent();
                    break;
                case 4:
                    adminServiceInter.deleteTeacher();
                    break;
                case 5:
                    adminServiceInter.updateStudent();
                    break;
                case 6:
                    adminServiceInter.updateTeacher();
                    break;
                case 7:
                    adminServiceInter.blockStudent();
                    break;
                case 8:
                    adminServiceInter.blockTeacher();
                    break;
                case 9:
                    adminServiceInter.openBlock();
                    break;
                case 10:
                    adminServiceInter.searchForStudent();
                    break;
                case 11:
                    adminServiceInter.searchForTeacher();
                    break;
                case 12:
                    adminServiceInter.adminLogIn();
                    break;
                case 13:
                    new BaseManagementServiceImpl().baseManagement();
                    break;
                default:
                    System.err.println("Invalid Option!");
            }
        }
    }
}
