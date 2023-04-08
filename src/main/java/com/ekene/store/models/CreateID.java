package com.ekene.store.models;

import java.util.Random;

public class CreateID {
    Random random = new Random();
    public CreateID(){ }

    public int createNum() {
        return random.nextInt(59);
    }

}
