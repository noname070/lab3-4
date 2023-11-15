package ru.noname070.lab3.actions;

import ru.noname070.lab3.characters.Character;

public class Patience extends Actions {
    public String runOut(Character c) {
        return "у "+c.getName()+" терпение лопнуло";
    }
}
