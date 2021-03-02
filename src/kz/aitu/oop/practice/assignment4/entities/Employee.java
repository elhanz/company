package kz.aitu.oop.practice.assignment4.entities;

import java.time.LocalDate;

public class Employee  {
    private int id;
    private String name;
    private String surname;
    private String job;
    private LocalDate dateOfHiring;
    private String department;
    private int salary;

    public Employee() {

    }

    public Employee(int id, String name, String surname, String job, LocalDate dateOfHiring, String department, int salary) {//construction to show
        this.id = id;
        this.name = name;
        this.surname = surname;
       this.job=job;
       this.dateOfHiring=dateOfHiring;
        this.department = department;
        this.salary = salary;
    }

    public Employee( String name, String surname, String job, LocalDate dateOfHiring, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.job=job;
        this.dateOfHiring=dateOfHiring;
        this.department = department;
        this.salary = salary;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {      return id;   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() { return surname;  }

    public void setSurname(String surname) {   this.surname = surname;   }

    public String getJob() {  return job;  }

    public void setJob(String job) {  this.job = job;   }

    public LocalDate getDateOfHiring() {  return dateOfHiring;  }

    public void setDateOfHiring(LocalDate dateOfHiring) {this.dateOfHiring = dateOfHiring;  }

    public String getDepartment() {  return department; }

    public void setDepartment(String department) {  this.department = department;  }

    public int getSalary() {   return salary;   }

    public void setSalary(int salary) {    this.salary = salary;  }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", job='" + job + '\'' +
                ", dateOfHiring=" + dateOfHiring +
                ", department='" + department + '\'' +
                ", salary=" + salary +'\''+
                '}'+'\n';
    }

}