package com.honeywell.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServerApplication.class, args);

        SQLiteTest test =  new SQLiteTest();
        ResultSet rs;
        try{
            rs= test.displayUsers();
            while (rs.next()){
                System.out.println(rs.getString("fName") + " " + rs.getString("lName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }


    }

}
