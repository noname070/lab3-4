package ru.noname070.lab3.locations;
import java.util.ArrayList;
import ru.noname070.lab3.characters.Character;


public interface IСharacterLocatable {

    public ArrayList<Character> getAllVisitors();
    public boolean isCharacterInLocation(Character c);
    public void joinCharacter(Character c);
    public void leaveCharacter(Character c);

}
