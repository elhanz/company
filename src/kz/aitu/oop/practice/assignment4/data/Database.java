package kz.aitu.oop.practice.assignment4.data;


import java.sql.Connection;
import java.sql.DriverManager;

public class Database implements DBInterface {
    public Connection getConnection() {//connection to postgresSQL
        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "4444");

            return connection;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
