package ru.noname070.lab3.characters;

import java.util.ArrayList;

import ru.noname070.lab3.entity.IEntity;
import ru.noname070.lab3.exceptions.CharacterMovementException;
import ru.noname070.lab3.locations.ICharacterLocatable;

public interface ICharacter extends IEntity {

    String getName();

    void setName(String name);

    void joinLocation(ICharacterLocatable l) throws CharacterMovementException;

    ICharacterLocatable getCurrentLocation();

    ArrayList<String> getThoughts();

    void goLookingFor(ICharacter targetCharacter, ICharacterLocatable targetLocation) throws CharacterMovementException;

    String divertHunger();

    String hungerStiffle(ArrayList<String> newThoughts);


}