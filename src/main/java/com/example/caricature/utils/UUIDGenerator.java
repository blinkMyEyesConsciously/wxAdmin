package com.example.caricature.utils;

import java.util.UUID;

public class UUIDGenerator {


    public static String getUUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        return  uuid;
    }

}