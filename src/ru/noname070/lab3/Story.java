package ru.noname070.lab3;

import java.util.ArrayList;
import java.util.Arrays;

import ru.noname070.lab3.characters.Character;
import ru.noname070.lab3.locations.СharacterLocatableImpl;
import ru.noname070.lab3.time.Time;

public class Story {
    public static void play() {
        int currentTime = Time.EVENING.getValue();
        System.out.println("Now it`s " + currentTime);

        СharacterLocatableImpl shelterLocation = new СharacterLocatableImpl("Убещише");
        СharacterLocatableImpl bridgeLocation = new СharacterLocatableImpl("Мост");
        СharacterLocatableImpl unknowLocation = new СharacterLocatableImpl("Неизвестнось");

        ArrayList<String> neznaykaThoughts = new ArrayList<String>(Arrays.asList("Ракета", "Пончик", "Козлик", "Темно здесь..."));
        Character neznaykaCharacter = new Character("Незнайка", shelterLocation, neznaykaThoughts);
        Character shortyCharacterImpl = new Character("Коротышка", bridgeLocation);
        Character kozlikCharacterImpl = new Character("Козлик", unknowLocation);

        ArrayList<String> newThoughts = new ArrayList<String>(Arrays.asList("Куда же запропастился Козлик?", "Почему он не возвращается?"));
        System.out.println(neznaykaCharacter.hungerStiffle(newThoughts));

        for (; currentTime < Time.DAYEND.getValue(); currentTime += 200 ) {
            System.out.println(neznaykaCharacter.divertHunger());
            System.out.println("Now it`s " + currentTime + "\n");
        }

        if (Time.DAYEND.getValue() == currentTime ) {
            System.out.println(neznaykaCharacter.goLookingFor(kozlikCharacterImpl, bridgeLocation));
        }

        System.out.println("[STORYEND]");

        System.out.println(neznaykaCharacter.toString());
        System.out.println("Hashcode " + neznaykaCharacter.hashCode());
    }
}
