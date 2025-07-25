package com.personal.rest_server;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {
    public static void main(String[] args) {
        String rawPassword = "1234";
        String storedHash = "$2a$10$40q4Pu26PW5wuTruseAESudOeWg6lyLZoKcb10IIYS9FbQeb/nA7q";
        System.out.println(new BCryptPasswordEncoder().encode("1234"));


        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (encoder.matches(rawPassword, storedHash)) {
            System.out.println("✅ Coincide con la base de datos.");
        } else {
            System.out.println("❌ No coincide.");
        }
    }
}
