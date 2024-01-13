package ru.noname070.lab3.locations;

import java.util.ArrayList;

import ru.noname070.lab3.characters.Character;
import ru.noname070.lab3.time.Time;

public class СharacterLocatableImpl extends Location implements IСharacterLocatable {
    public СharacterLocatableImpl(String name) {
        super(name);
    }

    private ArrayList<Character> visitors = new ArrayList<Character>();
    private ArrayList<LocatableHistory> history = new ArrayList<LocatableHistory>();


    public ArrayList<LocatableHistory> getHistory() {return history;}

    public ArrayList<Character> getAllVisitors() {
        return visitors;
    }

    public boolean isCharacterInLocation(Character c) {
        return visitors.contains(c);
    }

    public void joinCharacter(Character c) {
        visitors.add(c);
        System.out.println("Now " + c.getName() + " joint to " + this.getName());
    }
    public void joinCharacter(Character c, Time time) {
        visitors.add(c);
        LocatableHistory locationRecord = new LocatableHistory(c, this, time, Status.JOIN);
        history.add(locationRecord);
        System.out.println("Now " + c.getName() + " joint to " + this.getName());
    }

    public void leaveCharacter(Character c) {
        visitors.remove(c);

        System.out.println(c.getName() + " leaves from d" + this.getName());
    }

    public void leaveCharacter(Character c, Time time) {
        visitors.remove(c);
        LocatableHistory locationRecord = new LocatableHistory(c, this, time, Status.LEAVE);
        history.add(locationRecord);
        System.out.println(c.getName() + " leaves from d" + this.getName());
    }

}
