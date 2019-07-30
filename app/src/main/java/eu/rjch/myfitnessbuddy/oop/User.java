package eu.rjch.myfitnessbuddy.oop;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String email = "", name = "", location = "";
    // activities + level
    private Map<Integer, Integer> favActivities = new HashMap<>();

    public User(){

    }

    public User(String name, String email, String location){
        this.name = name;
        this.email = email;
        this.location = location;
    }
}
