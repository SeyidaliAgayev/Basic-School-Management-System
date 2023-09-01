import files.FileServiceInter;
import files.impl.FileServiceImpl;
import service.AdminServiceInter;
import service.impl.AdminServiceImpl;
import service.impl.BaseManagementServiceImpl;
import files.impl.FileServiceImpl.*;


public class Main {
    public static void main(String[] args) {
        new BaseManagementServiceImpl().baseManagement();
//        FileServiceInter fileService = new FileServiceImpl();
//        fileService.readInformation("personStudents.txt");
    }
}