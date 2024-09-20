package com.atividade_07.atividade_07.services;

import org.springframework.stereotype.Service;

@Service
public class PersonService {


    public static String validateAge(int age){
        return age >= 18 ? "Entry allowed": "Entry denied";
    }
}
