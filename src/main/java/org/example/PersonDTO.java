package org.example;

import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Setter
@Getter
public class PersonDTO {

    private String name;
    private String surname;
    private int age;


    public PersonDTO(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

}
