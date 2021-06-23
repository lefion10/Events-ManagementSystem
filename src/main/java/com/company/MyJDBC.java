package com.company;

import java.sql.*;


public class MyJDBC {
    public static void main(String[] args){
        try{
            // user example
            User user = new User("name","pass","firstName","lastName",1,1);
            //mysql database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcevents", "root","root");

            //mysql insert statement
            String query = " insert into users(username, password, firstname, lastname, idusers, sportid)"
                    + " values (?, ?, ?, ?, ?,?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString (1, user.getUsername());
            statement.setString (2, user.getPassword());
            statement.setString (3, user.getFirstName());
            statement.setString (4, user.getLastName());
            statement.setInt (5,user.getId());
            statement.setInt (6,user.getSportId());

            statement.execute();

            connection.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
