package org.hoover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HooverApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(HooverApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}