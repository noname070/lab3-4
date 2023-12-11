package ru.noname070.lab3.locations;

import java.util.ArrayList;

import ru.noname070.lab3.characters.CharacterImpl;
import ru.noname070.lab3.entity.Entity;

public class LocationImpl extends Entity implements Location{
    private String name;
    private ArrayList<CharacterImpl> visitors = new ArrayList<CharacterImpl>();

    public LocationImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<CharacterImpl> getAllVisitors() {
        return visitors;
    }

    public boolean isCharacterInLocation(CharacterImpl c) {
        return visitors.contains(c);
    }

    public void joinCharacter(CharacterImpl c) {
        visitors.add(c);
    }

    public void leaveCharacter(CharacterImpl c) {
        visitors.remove(c);
    }

} 