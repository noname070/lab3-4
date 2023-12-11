package ru.noname070.lab3;

import java.util.ArrayList;
import java.util.Arrays;

import ru.noname070.lab3.characters.Character;
import ru.noname070.lab3.locations.СharacterLocatableImpl;
import ru.noname070.lab3.time.Time;

public class Story {
    public static void play() {
        int currentTime = Time.EVENING.getValue();
        СharacterLocatableImpl shelterLocation = new СharacterLocatableImpl("Убещише");
        СharacterLocatableImpl bridgeLocation = new СharacterLocatableImpl("Мост");
        СharacterLocatableImpl unknowLocation = new СharacterLocatableImpl("Неизвестнось");

        ArrayList<String> neznaykaThoughts = new ArrayList<String>(Arrays.asList("one", "two", "three"));
        Character neznaykaCharacter = new Character("Незнайка", shelterLocation, neznaykaThoughts);
        Character shortyCharacterImpl  = new Character("Коротышка", bridgeLocation);
        Character kozlikCharacterImpl = new Character("Козлик", unknowLocation);

         ArrayList<String> newThoughts = new ArrayList<String>(Arrays.asList("Куда же запропастился Козлик?", "Почему он не возвращается?"));
        neznaykaCharacter.hungerStiffle(newThoughts);

        for (; currentTime > Time.DAYEND.getValue(); currentTime += 100 ) {
            neznaykaCharacter.divertHunger();
        } 


        if (Time.DAYEND.getValue() == currentTime ) {
            neznaykaCharacter.goLookingFor(kozlikCharacterImpl, bridgeLocation);
        }
    }
}
