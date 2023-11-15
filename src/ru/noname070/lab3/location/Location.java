package ru.noname070.lab3.location;

import java.util.ArrayList;

import ru.noname070.lab3.characters.Character;

public abstract class Location {
    private ArrayList<Character> visitors = new ArrayList<Character>();

    public void join(Character c) {
        visitors.add(c);
    }

    public void leave(Character c) {
        visitors.remove(c);
    }

    public ArrayList<Character> getAllVisitors() {
        return visitors;
    }
    
}