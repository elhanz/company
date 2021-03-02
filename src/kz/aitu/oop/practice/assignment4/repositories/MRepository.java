package kz.aitu.oop.practice.assignment4.repositories;

import  kz.aitu.oop.practice.assignment4.data.DBInterface;
import  kz.aitu.oop.practice.assignment4.entities.Employee;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MRepository implements IMRepository {
    private final DBInterface database;

    public MRepository(DBInterface database) {
        this.database = database;
    }


    @Override
    public ArrayList<Employee> searchEmployeeByName(String name) {
        Connection connection = null;
        try {
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where name= '" + name + "'");//finding employee by name
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("job"),
                        resultSet.getDate("dateofhiring").toLocalDate(),
                        resultSet.getString("department"),
                        resultSet.getInt("salary"));
                employees.add(employee);
            }
            return employees;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Employee> showAllEmployee() {
        Connection connection = null;
        try {
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee ");
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("job"),
                        resultSet.getDate("dateofhiring").toLocalDate(),
                        resultSet.getString("department"),
                        resultSet.getInt("salary"));
                employees.add(employee);
            }
            return employees;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public Employee getEmployeeById(int id) {
        Connection connection = null;
        try {
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id=?");//checking employee with this id
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = new Employee();
            if (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setJob(resultSet.getString("job"));
                employee.setDateOfHiring(resultSet.getDate("dateOfHiring").toLocalDate());
                employee.setDepartment(resultSet.getString("department"));
                employee.setSalary(resultSet.getInt("salary"));
            }
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        Connection connection = null;
        try {
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into employee(name, surname,job,dateofhiring,department,salary) values (?,?,?,?,?,?)");//inserting into database new employee
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setString(3, employee.getJob());
            preparedStatement.setDate(4, Date.valueOf(employee.getDateOfHiring()));
            preparedStatement.setString(5, employee.getDepartment());
            preparedStatement.setInt(6, employee.getSalary());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeEmployeeById(int id) {
        Connection connection = null;
        try {
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where id=?");//removing employee from database
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public ArrayList<Employee> searchEmployeeByDate(LocalDate date) {
        Connection connection = null;
        try {
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where dateofhiring=?");//finding employee with this hiring date

            preparedStatement.setDate(1, Date.valueOf(date));
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("job"),
                        resultSet.getDate("dateofhiring").toLocalDate(),
                        resultSet.getString("department"),
                        resultSet.getInt("salary"));
                employees.add(employee);
            }
            return employees;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int showCostOfProject(String department) {
        Connection connection = null;
        try {
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(" SELECT SUM(salary) FROM employee where department='" + department + "'" );//checking cost of department's project
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){

            }
            return resultSet.getInt("sum");}
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}