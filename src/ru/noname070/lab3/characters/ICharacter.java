package ru.noname070.lab3.characters;

import java.util.ArrayList;

import ru.noname070.lab3.entity.IEntity;
import ru.noname070.lab3.exceptions.CharacterMovementException;
import ru.noname070.lab3.locations.IСharacterLocatable;
import ru.noname070.lab3.time.ITimeContainer;

public interface ICharacter extends IEntity {

    String getName();

    void setName(String name);

    void joinLocation(IСharacterLocatable l) throws CharacterMovementException;

    IСharacterLocatable getCurrentLocation();

    ArrayList<String> getThoughts();

    String goLookingFor(ICharacter targetCharacter, IСharacterLocatable targetLocation) throws CharacterMovementException;

    Boolean goLookingFor(ICharacter targetCharacter);

    String divertHunger();

    String hungerStiffle(ArrayList<String> newThoughts);

    void timeUpdater(ITimeContainer currentTime);

}