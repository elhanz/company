package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.controllers.MController;
import kz.aitu.oop.practice.assignment4.data.Database;
import kz.aitu.oop.practice.assignment4.data.DBInterface;
import kz.aitu.oop.practice.assignment4.repositories.MRepository;
import kz.aitu.oop.practice.assignment4.repositories.IMRepository;

public class Main {

    public static void main(String[] args) {//Creating new objects and launching application
        DBInterface database= new Database();
        IMRepository medicineRepository = new MRepository(database);
        MController medicineController = new MController(medicineRepository);
        MyApplication myApplication = new MyApplication(medicineController);
        myApplication.start();
    }
}
