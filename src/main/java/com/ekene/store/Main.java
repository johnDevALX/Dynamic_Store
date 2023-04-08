package com.ekene.store;

import com.ekene.store.enumerations.Gender;
import com.ekene.store.enumerations.Role;
import com.ekene.store.models.Applicant;
import com.ekene.store.models.CreateID;
import com.ekene.store.models.Manager;
import com.ekene.store.serviceImplementations.ManagerService;

public class Main {
    public static void main(String[] args) {
        Applicant applicant = new Applicant("John", "Ben", 24, Gender.MALE,
                "john@ben.com", Role.CASHIER, 4);
        CreateID createID = new CreateID();
        int num1 = createID.createNum();
        Applicant applicant1 = new Applicant("Zee", "Zintle", 29, Gender.FEMALE,
                "zee@z.com", Role.CASHIER, 5);
        int num2 = createID.createNum();
        Applicant applicant2 = new Applicant("Faith", "Haibo", 20, Gender.FEMALE,
                "faith@ha.com", Role.CASHIER,5);
        int num3 = createID.createNum();

        ManagerService managerService = new ManagerService();
        managerService.hireACashier(applicant, num1);
        managerService.hireACashier(applicant1, num2);
        managerService.hireACashier(applicant2, num3);

        Manager.CASHIER_LIST.forEach(System.out::println);
        managerService.fireACashier("faith");
        Manager.CASHIER_LIST.forEach(System.out::println);
    }
}
