package ru.noname070.lab3.characters;

import java.util.ArrayList;

import ru.noname070.lab3.exceptions.CharacterMovementException;
import ru.noname070.lab3.locations.СharacterLocatableImpl;
import ru.noname070.lab3.time.CurrentTimeContainer;

public interface ICharacter {

    String getName();

    void setName(String name);

    void joinLocation(СharacterLocatableImpl l) throws CharacterMovementException;

    СharacterLocatableImpl getCurrentLocation();

    ArrayList<String> getThoughts();

    String goLookingFor(Character targetCharacter, СharacterLocatableImpl targetLocation) throws CharacterMovementException;

    Boolean goLookingFor(Character targetCharacter);

    String divertHunger();

    String hungerStiffle(ArrayList<String> newThoughts);

    void timeUpdater(CurrentTimeContainer currentTime);

}