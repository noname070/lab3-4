package ru.noname070.lab3;

import java.util.ArrayList;
import java.util.Arrays;

import ru.noname070.lab3.characters.*;
import ru.noname070.lab3.characters.Character;
import ru.noname070.lab3.characters.TrashChest.Trash;
import ru.noname070.lab3.exceptions.CharacterMovementException;
import ru.noname070.lab3.locations.CharacterLocatableImpl;
import ru.noname070.lab3.time.*;

public class Story {
    public static void play() throws CharacterMovementException {
        CurrentTimeContainer currentTime = new CurrentTimeContainer(Time.MORNING.getValue());
        System.out.println("now it`s " + currentTime.toString());

        CharacterLocatableImpl shelterLocation = new CharacterLocatableImpl("Убежише", currentTime, -.5);
        CharacterLocatableImpl bridgeLocation = new CharacterLocatableImpl("Мост", currentTime);
        CharacterLocatableImpl unknownLocation = new CharacterLocatableImpl("Неизвестнось", currentTime);

        ArrayList<String> neznaykaThoughts = new ArrayList<>(
                Arrays.asList("Ракета", "Пончик", "Козлик", "Темно здесь..."));
        Character neznaykaCharacter = new Character("Незнайка", shelterLocation, neznaykaThoughts, currentTime);
        Character shortyCharacterImpl = new Character("Коротышка", bridgeLocation, currentTime);
        Character kozlikCharacterImpl = new Character("Козлик", unknownLocation, currentTime);

        ArrayList<String> newThoughts = new ArrayList<>(
                Arrays.asList("Куда же запропастился Козлик?", "Почему он не возвращается?"));
        System.out.println(neznaykaCharacter.hungerStiffle(newThoughts));

        GlobalTimeUpdater time = new GlobalTimeUpdater(currentTime,
                neznaykaCharacter, shortyCharacterImpl, kozlikCharacterImpl,
                shelterLocation, bridgeLocation, unknownLocation);

        for (; currentTime.getCurrentTime() < Time.EVENING.getValue(); currentTime.addToCurrentTime(200)) {
            time.timeStep();
        }

        if (Time.EVENING.getValue() == currentTime.getCurrentTime()) {
            try {
                neznaykaCharacter.goLookingFor(kozlikCharacterImpl, bridgeLocation);
            } catch (CharacterMovementException charMoveExc) {
                System.out.println("character can`t move here");
                System.exit(-342);
            }
        }

        // dialog
        shortyCharacterImpl.say("Что ты здесь делаешь?", neznaykaCharacter);
        neznaykaCharacter.say("Сижу", shortyCharacterImpl);
        shortyCharacterImpl.say("Я не видел тебя здесь раньше", neznaykaCharacter);
        neznaykaCharacter.say("Потому что я не сидел здесь раньше", kozlikCharacterImpl);

        currentTime.setCurrentTime(Time.DAYEND.getValue());
        bridgeLocation.setBias(.15); // lights on

        Shorties manyShorties = new Shorties() {

            private ArrayList<ICharacter> shorties = new ArrayList<>();
            private boolean areSleeping = false;

            @Override
            public void timeUpdater(ITimeContainer currentTime) {
                double fatigue = Math.tanh(currentTime.getCurrentTime() * 3.5 - 2) * .5 + .6;
                if (fatigue > .6 & !this.areSleeping) {
                    for (ICharacter s : this.shorties) {
                        this.goSleeping(s);
                    }
                    this.areSleeping = !this.areSleeping;
                }
            }

            @Override
            public void setCurrentTime(ITimeContainer time) throws CharacterMovementException {
                this.shorties = new ArrayList<>(
                        Arrays.asList(
                                new Character("Миллиончик", shelterLocation, time),
                                new Character("Пузырь", shelterLocation, time)));
            }

            @Override
            public void goSleeping(ICharacter c) {
                System.out.println(c.getName() + "go Zzz with " +
                        new TrashChest(c.getName().equals("Пузырь") ? Trash.RUBBER_PILLOW : Trash.OLD_MATTRESS)
                                .makeSleepingPlaceFrom());
            }

        };

        manyShorties.setCurrentTime(currentTime);
        time.addObjects2Update(manyShorties);

        for (; currentTime.getCurrentTime() < Time.FULL_DAY.getValue(); currentTime.addToCurrentTime(200)) {
            time.timeStep();
        }

        System.out.println("\n");

        System.out.println("[STORYEND]");

        System.out.println("Neznayka`s toString : " + neznaykaCharacter);
        System.out.println("Neznayka`s Hashcode " + neznaykaCharacter.hashCode());

        System.out.println("Shelter`s toString : " + shelterLocation);
        System.out.println("Shelter`s Hashcode : " + shelterLocation.hashCode());
    }
}
