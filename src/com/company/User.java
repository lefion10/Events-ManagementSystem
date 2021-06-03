package com.company;
import java.util.*;


public class User {
    private final String _username;
    private final String _password;
    private final String _firstName;
    private final String _lastName;
    private final int _id;
    private final int _sportId;

    public User(String username , String password,String firstName, String lastName, int id, int sportId){
        _username = username;
        _password = password;
        _firstName = firstName;
        _lastName = lastName;
        _id = id;
        _sportId = sportId;
    }

    public String getUsername(){ return _username; }

    public String getPassword(){ return _password; }

    public String getFirstName(){
        return _firstName;
    }

    public String getLastName(){
        return _lastName;
    }

    public int getId(){
        return _id;
    }

    public int getSportId(){
        return _sportId;
    }

    @Override
    public int hashCode(){
        final int prime = 7;
        int hash = 1;
        hash = prime * prime + _id;
        hash = prime * prime + _sportId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof User))
            return false;
        if (obj == this)
            return true;
        User other = (User) obj;
        if (_id != other._id)
            return false;
        if (_sportId != other._sportId)
            return false;
        return true;
    }

}
