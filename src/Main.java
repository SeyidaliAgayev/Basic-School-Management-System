
import data.GlobalData;


import model.Student;
import service.impl.BaseManagementServiceImpl;
import service.impl.ExamServiceImpl;

import static service.impl.LogInServiceImpl.*;



public class
Main {
    public static void main(String[] args) {
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            System.out.println(GlobalData.personDynamicArrays.get(i));
        }
        BaseManagementServiceImpl.getInstance().baseManagement();
    }
}