package com.ekene.store.models;
import com.ekene.store.enumerations.Gender;
import com.ekene.store.enumerations.Role;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Cashier extends Person{
    private String email;
    private int salary;
    private Role role;
    private int id;
    private int superId;
    public Cashier() {}
    public Cashier(String firstName, String lastName, int age, Gender gender, String email, int salary, Role role, int id, int superId) {
        super(firstName, lastName, age, gender);
        this.email = email;
        this.salary = salary;
        this.role = role;
        this.id = id;
        this.superId = superId;
    }

    public String toString() {
        return "Cashier{Firstname: " + super.getFirstName() +
                ", Lastname: " + super.getLastName() +
                ", Age: " + super.getAge() +
                ", Gender:" + super.getGender() +
                ", Email:" + email +
                ", Salary: " + salary +
                ", Role: " + role +
                ", Id: " + id +
                ", Supervisor_Id: " + superId +
                '}';
    }
}
