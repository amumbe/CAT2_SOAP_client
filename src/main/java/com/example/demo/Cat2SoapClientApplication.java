package com.example.demo;

import localhost.universities.GetUniversityResponse;
import localhost.universities.University;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Cat2SoapClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cat2SoapClientApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(Client universityClient){

        return args -> {
            String name = "KU";
            if(args.length>0){
               name = args[0];
            }

            GetUniversityResponse response = universityClient.getUniversityResponse(name);
            University university = response.getUniversity();
            System.out.println("University " +university);
//            System.out.println("University"+response.getUniversity());
           System.out.println(
                      "University Name: "+university.getName()+
                           "\n University's location: "+university.getLocation()+
                          "\n Year Founded: "+university.getYearFounded())
           ;
        };

    }

}
