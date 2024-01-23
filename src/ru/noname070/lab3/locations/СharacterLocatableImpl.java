package ru.noname070.lab3.locations;

import java.util.ArrayList;

import ru.noname070.lab3.characters.Character;
import ru.noname070.lab3.time.CurrentTimeContainer;
import ru.noname070.lab3.exceptions.*;

public class СharacterLocatableImpl extends Location implements IСharacterLocatable {
    public СharacterLocatableImpl(String name, CurrentTimeContainer currentTime) {
        super(name, currentTime);
    }
    
    public СharacterLocatableImpl(String name, CurrentTimeContainer currentTime, double visibility_bias) {
        super(name, currentTime, visibility_bias);
    }

    private ArrayList<Character> visitors = new ArrayList<Character>();

    @Override
    public ArrayList<Character> getAllVisitors() {
        // return visitors;
        if (visitors.size() > 0) return visitors;
        else throw new NoAnyVisitorsError("No any visitors in " + getName());
    }

    @Override
    public boolean isCharacterInLocation(Character c) {
        return visitors.contains(c);
    }

    @Override
    public void joinCharacter(Character c) throws CharacterMovementException {
        if (!visitors.contains(c)) {
            visitors.add(c);
            System.out.println("Now " + c.getName() + " joint to " + this.getName());

        } else throw new CharacterMovementException("Character " + getName() + "cat`t perform this move");
    }

    @Override
    public void leaveCharacter(Character c) throws CharacterMovementException {
        if (visitors.contains(c)) {
            visitors.remove(c);
            System.out.println(c.getName() + " leaves from d" + this.getName());
        } else throw new CharacterMovementException("Character " + getName() + "cat`t perform this move");

    }

    // public void turnLights(Status s) {
    //     lightsStatus = lightsStatus == Status.OFF ? Status.ON : Status.ON;
    // }


}
