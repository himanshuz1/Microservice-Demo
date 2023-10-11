package com.immutable.demo;

import java.util.UUID;

public class GenerateRandomUUID {

    public static void main(String[] args) {
        String txUUID = UUID.randomUUID().toString().replace("-", "");
        System.out.println(txUUID);
    }
}
