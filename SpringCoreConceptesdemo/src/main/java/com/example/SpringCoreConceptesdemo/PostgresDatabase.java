package com.example.SpringCoreConceptesdemo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Primary
//@Profile("prod")
@ConditionalOnProperty(name = "Db_type", havingValue = "postgres")
public class PostgresDatabase implements Database{

    @Override
    public void save(String user) {
        System.out.println("Postgres database connected successfully "+ user);
    }
}
