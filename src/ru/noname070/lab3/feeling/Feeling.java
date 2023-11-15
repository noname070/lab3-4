package ru.noname070.lab3.feeling;

import ru.noname070.lab3.Entity;
import ru.noname070.lab3.characters.Character;

public interface Feeling extends Entity {
    String realise(Character c);   
} 