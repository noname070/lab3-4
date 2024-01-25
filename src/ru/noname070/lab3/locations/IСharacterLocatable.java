package ru.noname070.lab3.locations;

import java.util.ArrayList;

import ru.noname070.lab3.characters.ICharacter;
import ru.noname070.lab3.exceptions.*;

public interface IСharacterLocatable {

    ArrayList<ICharacter> getAllVisitors();

    boolean isCharacterInLocation(ICharacter c);

    void joinCharacter(ICharacter c) throws CharacterMovementException;

    void leaveCharacter(ICharacter c) throws CharacterMovementException;

    String getName();

}