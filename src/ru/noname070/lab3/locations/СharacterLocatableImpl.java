package ru.noname070.lab3.locations;

import java.util.ArrayList;

import ru.noname070.lab3.characters.Character;

public class СharacterLocatableImpl extends Location implements IСharacterLocatable {
    public СharacterLocatableImpl(String name) {
        super(name);
    }

    private ArrayList<Character> visitors = new ArrayList<Character>();

    public ArrayList<Character> getAllVisitors() {
        return visitors;
    }

    public boolean isCharacterInLocation(Character c) {
        return visitors.contains(c);
    }

    public void joinCharacter(Character c) {
        visitors.add(c);
    }

    public void leaveCharacter(Character c) {
        visitors.remove(c);
    }

}
