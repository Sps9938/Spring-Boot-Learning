package com.example.SpringCoreConceptesdemo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
//@Primary
//@Profile("dev")
@ConditionalOnProperty(name = "Db_type", havingValue = "mysql")
public class MySQLDatabase implements Database{

    @Override
    public void save(String user) {
        System.out.println("MySQL database connected successfully "+ user);
    }
}
