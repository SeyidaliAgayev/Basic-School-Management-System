import classes.Classes;
import data.GlobalData;
import service.impl.BaseManagementServiceImpl;


public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            System.out.println(GlobalData.personDynamicArrays.get(i).toString());
        }
        BaseManagementServiceImpl.getInstance().baseManagement();
    }

}