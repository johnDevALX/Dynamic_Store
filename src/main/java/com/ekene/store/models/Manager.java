package com.ekene.store.models;
import com.ekene.store.enumerations.Gender;
import com.ekene.store.enumerations.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class Manager{
    public static List<Cashier> CASHIER_LIST = new ArrayList<>();
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private int salary;
    private Role role;
    private int id;

    public Manager(String firstName, String lastName, String email, Gender gender, int salary, Role role, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
        this.role = role;
        this.id = id;
    }
    public Manager(){ }

}
