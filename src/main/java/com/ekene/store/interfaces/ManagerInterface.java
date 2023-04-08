package com.ekene.store.interfaces;

import com.ekene.store.models.Applicant;
import com.ekene.store.models.Cashier;
import com.ekene.store.models.CreateID;

public interface ManagerInterface {
    Cashier hireACashier(Applicant applicant, int num);

    String fireACashier(String name);
}
