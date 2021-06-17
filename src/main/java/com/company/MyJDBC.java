package com.company;

import java.sql.*;


public class MyJDBC {
    public static void main(String[] args){
        try{
            // event example

            //mysql database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcevents", "root","root");

            //mysql insert statement
            String query = " insert into event(name, date, prize, idevents, sportid ,locationid)"
                    + " values (?, ?, ?, ?, ?,?)";

//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString (1, event.getName() );
//            statement.setInt (3, event.getPrize() );
//            statement.setInt (4,event.getId() );
//            statement.setInt (5,event.getSportId() );
//            statement.setInt (6,event.getLocation());
//
//            statement.execute();

            connection.close();


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
