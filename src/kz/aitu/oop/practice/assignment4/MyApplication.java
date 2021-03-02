package kz.aitu.oop.practice.assignment4;
import kz.aitu.oop.practice.assignment4.controllers.MController;

import java.time.LocalDate;
import java.util.Scanner;

public class MyApplication {
    private final MController MController;
    private final Scanner scanner;

    public MyApplication(MController MController) {
        this.MController = MController;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while(true) {
            System.out.println("Choose one option:\n 1) Search for any employee by name\n 2) Get employee by id\n 3) Add employee\n 4) Remove employee\n 5) Show all employee \n 6) Search employee by date \n 7) Search project's cost \n  0) Exit\n");
            int choice = scanner.nextInt();

            if (choice==1) {
                searchEmployeeByName( );
            }
            else if (choice==2) {
                getEmployeeByIdMenu();
            }
            else if (choice==3) {
                addEmployeeMenu();
            }
            else if (choice==4) {
                removeEmployeeByIdMenu();
            }
            else if (choice==5) {
                showAllEmployee();
            }
            else if (choice==6) {
                searchEmployeeByDate();
            }
            else if (choice==7) {
                showCostOfProject();
            }
            else {
                break;
            }

            System.out.println("*************************************************");
        }
    }

    public void searchEmployeeByName() {
        System.out.println("Write the name of employee");
        String name = scanner.next();
        String result = MController.searchEmployeeByName(name);
        System.out.println(result);
    }

    public void getEmployeeByIdMenu() {
        System.out.println("Write the id of employee");
        int id = scanner.nextInt();
        String result = MController.getEmployeeById(id);
        System.out.println(result);
    }

    public void addEmployeeMenu() {
        System.out.println("Write the name of employee");
        String name = scanner.next();
        System.out.println("Write the surname of employee");
        String surname = scanner.next();
        System.out.println("Write the job of employee");
        String job = scanner.next();
        System.out.println("Write employee's hiring date in yyyy-mm-dd format");
        String dateofhiring = scanner.next();
        LocalDate dateOfHiring= LocalDate.parse(dateofhiring);
        System.out.println("Write employee's department");
        String department = scanner.next();
        System.out.println("Write employee's salary");
        int salary = scanner.nextInt();

        String result = MController.addEmployee(name,surname,job, dateOfHiring, department,salary);

        System.out.println(result);
    }


    public void removeEmployeeByIdMenu() {
        System.out.println("Write employee's id");
        int id = scanner.nextInt();

        String result = MController.removeEmployeeById(id);

        System.out.println(result);
    }
    public void showAllEmployee() {
        System.out.println("employee: \n");

        String result = MController.showAllEmployee();

        System.out.println(result);
    }
    public void searchEmployeeByDate() {
        System.out.println("Write employee's hiring date: \n");;
        String date = scanner.next();
        String result = MController.searchEmployeeByDate(LocalDate.parse(date));
        System.out.println(result);
    }
public  void showCostOfProject(){
    System.out.println("Write department's name: \n");;
    String department = scanner.next();
    String result = MController.showCostOfProject(department);
    System.out.println(result);
}
}