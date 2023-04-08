package com.ekene.store.models;

import com.ekene.store.enumerations.Gender;
import com.ekene.store.enumerations.Role;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class Applicant extends Person{
    private String email;
    private Role roleAppliedFor;
    private int yearsOfExperience;

    public Applicant(){}
    public Applicant(String firstName, String lastName, int age, Gender gender, String email, Role roleAppliedFor, int yearsOfExperience){
        super(firstName, lastName, age, gender);
        this.email = email;
        this.roleAppliedFor = roleAppliedFor;
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "Applicant{firstName" + super.getFirstName() +
                " lastName: " + super.getLastName() +
                " Age: " + super.getAge() +
                " Gender: " + super.getGender() +
                " Email: " + email +
                " RoleAppliedFor: " + roleAppliedFor +
                " yearsOfExperience=" + yearsOfExperience +
                '}';
    }
}
