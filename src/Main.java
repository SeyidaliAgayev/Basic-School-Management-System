import service.AdminServiceInter;
import service.impl.AdminServiceImpl;
import service.impl.BaseManagementServiceImpl;

public class Main {
    public static void main(String[] args) {
            new BaseManagementServiceImpl().baseManagement();
    }
}