package ru.noname070.lab3;

import java.util.ArrayList;
import java.util.Arrays;

import ru.noname070.lab3.characters.Character;
import ru.noname070.lab3.locations.СharacterLocatableImpl;
import ru.noname070.lab3.time.CurrentTimeContainer;
import ru.noname070.lab3.time.GlobalTimeUpdater;
import ru.noname070.lab3.time.Time;

public class Story {
    public static void play() {
        CurrentTimeContainer currentTime = new CurrentTimeContainer(Time.MORNING.getValue());
        System.out.println("Now it`s " + currentTime.toString());

        СharacterLocatableImpl shelterLocation = new СharacterLocatableImpl("Убещише", currentTime, -.5);
        СharacterLocatableImpl bridgeLocation = new СharacterLocatableImpl("Мост", currentTime);
        СharacterLocatableImpl unknowLocation = new СharacterLocatableImpl("Неизвестнось", currentTime);

        ArrayList<String> neznaykaThoughts = new ArrayList<String>(Arrays.asList("Ракета", "Пончик", "Козлик", "Темно здесь..."));
        Character neznaykaCharacter = new Character("Незнайка", shelterLocation, neznaykaThoughts, currentTime);
        Character shortyCharacterImpl = new Character("Коротышка", bridgeLocation, currentTime);
        Character kozlikCharacterImpl = new Character("Козлик", unknowLocation, currentTime);

        ArrayList<String> newThoughts = new ArrayList<String>(Arrays.asList("Куда же запропастился Козлик?", "Почему он не возвращается?"));
        System.out.println(neznaykaCharacter.hungerStiffle(newThoughts));

        // // for (; currentTime < Time.EVENING.getValue(); currentTime += 200 ) {
        // for (; currentTime.getCurrentTime() < Time.EVENING.getValue(); currentTime.addToCurrentTime(200) ) {
        //     System.out.println(neznaykaCharacter.divertHunger());
        //     System.out.println("Now it`s " + currentTime.getCurrentTime() + "\n");
        // }

        GlobalTimeUpdater time = new GlobalTimeUpdater(     currentTime,
            neznaykaCharacter, shortyCharacterImpl, kozlikCharacterImpl,
            shelterLocation, bridgeLocation, unknowLocation             );
        
        for (; currentTime.getCurrentTime() < Time.EVENING.getValue(); currentTime.addToCurrentTime(200)) {
            time.timeStep();
        }

        if (Time.EVENING.getValue() == currentTime.getCurrentTime() ) {
            System.out.println(neznaykaCharacter.goLookingFor(kozlikCharacterImpl, bridgeLocation));
        }

        if (!shortyCharacterImpl.goLookingFor(neznaykaCharacter)) {
            System.exit(-1); // xd
        }

        currentTime.setCurrentTime(Time.DAYEND.getValue());
        bridgeLocation.setBias(.15); // lights on

        Character millionchikCharacter = new Character("Миллиончик", shelterLocation, currentTime);
        Character puzirCharacter = new Character("Пузыр", shelterLocation, currentTime);






        System.out.println("[STORYEND]");

        System.out.println(neznaykaCharacter.toString());
        System.out.println("Hashcode " + neznaykaCharacter.hashCode());
    }
}
