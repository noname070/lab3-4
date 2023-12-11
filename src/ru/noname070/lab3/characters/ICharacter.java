package ru.noname070.lab3.characters;

import java.util.ArrayList;

import ru.noname070.lab3.locations.СharacterLocatableImpl;

public interface ICharacter {

    public String getName();
    public void joinLocation(СharacterLocatableImpl l);
    public СharacterLocatableImpl getCurrentLocation();
    public ArrayList<String> getThoughts();
    public String goLookingFor(Character targetCharacter, СharacterLocatableImpl targetLocation);
    public String divertHunger();
    public String hungerStiffle(ArrayList<String> newThoughts);

}
