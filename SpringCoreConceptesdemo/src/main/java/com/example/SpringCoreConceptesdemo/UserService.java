package com.example.SpringCoreConceptesdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service

public class UserService {
    Database database;

    public UserService(Database database){
        this.database = database;
    }

    public void saveUser(String user) {
        System.out.println("User saved successfully " + user);
        database.save(user);

    }
}
