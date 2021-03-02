package kz.aitu.oop.practice.assignment4.controllers;

import kz.aitu.oop.practice.assignment4.entities.Employee;
import kz.aitu.oop.practice.assignment4.repositories.IMRepository;

import java.time.LocalDate;


public class MController {
    private final IMRepository mRepository;

    public MController (IMRepository mRepository){
        this.mRepository=mRepository;
    }
    public String searchEmployeeByName(String name) {
        String result = mRepository.searchEmployeeByName(name).toString();
        return result;
    }

    public String getEmployeeById(int id) {
        String result = mRepository.getEmployeeById(id).toString();

        return result;
    }
    public String searchEmployeeByDate(LocalDate date) {//to show employee by date of hiring
        String result = mRepository.searchEmployeeByDate(date).toString();

        return result;
    }
    public String showAllEmployee( ) {
        String result = mRepository.showAllEmployee().toString();
        return result;
    }
    public String showCostOfProject( String department) {//to show project's cost
        String result = String.valueOf(mRepository.showCostOfProject(department));
        return result;
    }

    public String addEmployee(String name, String surname, String job, LocalDate dateOfHiring, String department, int salary) {

        boolean added = mRepository.addEmployee(new Employee(name,surname,job, dateOfHiring, department,salary));// to know if it was/wasn't added

        if (added) {
            return "Employee was added  \n";
        }
        return "Employee wasn't added \n ";
    }

    public String removeEmployeeById(int id) {
        boolean removed = mRepository.removeEmployeeById(id);// to know if it was/wasn't removed

        if (removed) {
            return "Employee was removed   \n";
        }

        return "Employee wasn't removed   \n";
    }
}