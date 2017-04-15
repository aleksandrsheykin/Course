package com.company;

import com.company.planning.models.User;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;

public class Main {

    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        //User user = new User("Uriy", "Shevchuk", "Shevchuk@mail.ru", "12345", 1000);
        User user = new User();
        user.get(3);
        System.out.println(user.toString());
        //user.setFirstName("Mick");
        //user.update();

        System.out.println(user.toString());


    }
}
