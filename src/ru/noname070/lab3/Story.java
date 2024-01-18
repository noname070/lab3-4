package ru.noname070.lab3;

import java.util.ArrayList;
import java.util.Arrays;

import javax.sound.midi.Track;

import ru.noname070.lab3.characters.Character;
import ru.noname070.lab3.entity.Entity;
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

        // dialog


        currentTime.setCurrentTime(Time.DAYEND.getValue());
        bridgeLocation.setBias(.15); // lights on


        // Character millionchikCharacter = new Character("Миллиончик", shelterLocation, currentTime);
        // Character puzirCharacter = new Character("Пузыр", shelterLocation, currentTime);

        class StoryAboutShorties extends Entity.TimeSlaveEntity {
            String name;
            Character.TrashChest.Trash personTrash;

            double ustalast = 0.0;


            public StoryAboutShorties(String name, Character.TrashChest.Trash personalTrash) {
                this.name = name;
                this.personTrash = personalTrash;
            }

            private boolean isSleeping = false;

            public void goSleeping() {
                this.isSleeping = true;
                System.out.println(this.name + " go Zzz with " + personTrash.toString());
            }

            @Override
            public void timeUpdater(CurrentTimeContainer currentTime) {
                this.ustalast = Math.tanh(currentTime.getCurrentTime()*3.5 - 2 ) * .5 + .6;
                if (this.ustalast > .6) {
                    if (!isSleeping) { goSleeping(); };
                }
            }
            
        }

        StoryAboutShorties sh1 = new StoryAboutShorties("Миллиончик", Character.TrashChest.Trash.OLD_MATTRESS);
        StoryAboutShorties sh2 = new StoryAboutShorties("Пузырь", Character.TrashChest.Trash.RUBBER_PILLOW);
        time.addObjects2Update(sh1, sh2);

        for (; currentTime.getCurrentTime() < Time.FULLDAY.getValue(); currentTime.addToCurrentTime(200)) {
            time.timeStep();
        }

        System.out.println("\n\n\n");
        
    
        System.out.println("[STORYEND]");

        System.out.println("Neznayka`s " + neznaykaCharacter.toString());
        System.out.println("Neznayka`s Hashcode " + neznaykaCharacter.hashCode());
    }
}
