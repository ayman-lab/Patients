package com.example.demo;

import com.example.demo.entites.Patient;
import com.example.demo.reposetories.PatienReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {
    @Autowired
    private PatienReposetory patienReposetory;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       /* patienReposetory.save(new Patient(null,"khalid",new Date(),4200,true));
        patienReposetory.save(new Patient(null,"ayman",new Date(),1400,false));
        patienReposetory.save(new Patient(null,"assya",new Date(),3200,false));
        patienReposetory.save(new Patient(null,"ahmed",new Date(),2154,false));*/




    }
}
