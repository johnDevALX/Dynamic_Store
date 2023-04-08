package com.ekene.store.models;

import com.ekene.store.enumerations.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public abstract class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    protected Person() {
    }
}
