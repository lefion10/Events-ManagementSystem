package com.company;
import java.util.*;

public class UsersList {
    private final Map<Integer,User> users = new HashMap<>();

    public void addUser(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        int id = user.getId();

        addUser(user,username,password,id);
    }

    private boolean conflictsWith(String username, String password, String comUsername, String comPassword){
        return (username.equals(comUsername) && password.equals(comPassword));
    }

    private Optional<User> findConflictingUser(String username, String password, List<User> usersList){
        return usersList.stream()
                .filter(users -> conflictsWith(users.getUsername(), users.getPassword(), username, password))
                .findAny();
    }

    private void addUser(User user, String username, String password, int id){
        List<User> userList = (List<User>) users.get(id);

        if(userList == null){
            userList = new ArrayList<>();
            userList.add(new User(username, password, user.getFirstName(), user.getLastName(), id, user.getSportId()));
            users.put(id,user);
        }else{
            Optional<User> conflictingUser = findConflictingUser(username,password,userList);

            if(!conflictingUser.isPresent()){
                userList.add(new User(username, password, user.getFirstName(), user.getLastName(), id, user.getSportId()));
            }
        }
    }

    public Map<Integer, User> getUsers() {
        return users;
    }
}
