package kz.aitu.oop.practice.assignment4.repositories;


import kz.aitu.oop.practice.assignment4.entities.Employee;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IMRepository {//there are methods of application
    public ArrayList<Employee> searchEmployeeByName(String name);
    public ArrayList<Employee>  showAllEmployee();
    public Employee getEmployeeById(int id);
    public  boolean addEmployee (Employee employee);
    public boolean removeEmployeeById(int id);
    public ArrayList<Employee> searchEmployeeByDate(LocalDate date);
    public int showCostOfProject(String department) ;
}
