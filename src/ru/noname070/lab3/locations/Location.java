package ru.noname070.lab3.locations;

import ru.noname070.lab3.characters.CharacterImpl;

public interface Location {

    public String getName();
    public boolean isCharacterInLocation(CharacterImpl c);
    public void joinCharacter(CharacterImpl c);
    public void leaveCharacter(CharacterImpl c);
}
