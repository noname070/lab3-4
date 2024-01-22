package ru.noname070.lab3.locations;

import java.util.ArrayList;

import ru.noname070.lab3.characters.Character;
import ru.noname070.lab3.exceptions.*;

public interface IСharacterLocatable {

    // ArrayList<LocatableHistory> getHistory();

    ArrayList<Character> getAllVisitors();

    boolean isCharacterInLocation(Character c);

    void joinCharacter(Character c) throws CharacterMovementException;

    void leaveCharacter(Character c) throws CharacterMovementException;

}