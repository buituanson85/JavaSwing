package JavaII.Assignment5.Controller;

import JavaII.Assignment5.Dao.EmployeeDAO;

import java.util.Scanner;

public class MenuController {
    private static MenuController instance = null;

    public MenuController() {
    }

    public synchronized static MenuController getInstance() {
        if (instance == null){
            instance = new MenuController();
        }
        return instance;
    }

    public void programme(){
        while (true){
            Scanner sc = new Scanner(System.in);
            EmployeeDAO employeeDAO = new EmployeeDAO();
            System.out.println("====== Please enter the number of employees needed ======");
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++ ){
                System.out.println("Enter employee name ");
                String _name = sc.nextLine();
                System.out.println("Enter salary coefficient");
                float _salary = Float.parseFloat(sc.nextLine());
                System.out.println("Insurance salary entry");
                float _insurance = Float.parseFloat(sc.nextLine());
                employeeDAO.create(_name, _salary, _insurance);
            }
            System.out.println("Do you want to continue or not(Y/N): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("N")){
                employeeDAO.findAll();
                break;
            }
        }
    }
}
