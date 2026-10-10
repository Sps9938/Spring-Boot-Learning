package com.example.SpringCoreConceptesdemo;

public class UserService {
    MySQLDatabase mySQLDatabase = new MySQLDatabase();
    public void saveUser(String user) {
        System.out.println("User saved successfully!");
        mySQLDatabase.saveToDB(user);
    }
}
