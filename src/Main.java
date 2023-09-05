import data.GlobalData;
import files.FileServiceInter;
import files.impl.FileServiceImpl;
import model.Admin;
import service.AdminServiceInter;
import service.impl.AdminServiceImpl;
import service.impl.BaseManagementServiceImpl;
import files.impl.FileServiceImpl.*;



public class Main {
    static FileServiceInter fileService;
    public static void main(String[] args) {
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            System.out.println(GlobalData.personDynamicArrays.get(i).toString());
        }
        BaseManagementServiceImpl.getInstance().baseManagement();
    }
}