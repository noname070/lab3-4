package ru.noname070.lab3;

import java.util.ArrayList;
import java.util.Arrays;

import ru.noname070.lab3.characters.Character;
import ru.noname070.lab3.characters.ICharacter;
import ru.noname070.lab3.characters.Shorties;
import ru.noname070.lab3.characters.TrashChest;
import ru.noname070.lab3.characters.TrashChest.Trash;
import ru.noname070.lab3.exceptions.CharacterMovementException;
import ru.noname070.lab3.locations.СharacterLocatableImpl;
import ru.noname070.lab3.time.CurrentTimeContainer;
import ru.noname070.lab3.time.GlobalTimeUpdater;
import ru.noname070.lab3.time.ITimeContainer;
import ru.noname070.lab3.time.Time;

public class Story {
    public static void play() throws CharacterMovementException {
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

        GlobalTimeUpdater time = new GlobalTimeUpdater(     currentTime,
            neznaykaCharacter, shortyCharacterImpl, kozlikCharacterImpl,
            shelterLocation, bridgeLocation, unknowLocation             );
        
        for (; currentTime.getCurrentTime() < Time.EVENING.getValue(); currentTime.addToCurrentTime(200)) {
            time.timeStep();
        }

        if (Time.EVENING.getValue() == currentTime.getCurrentTime() ) {
            try {
                System.out.println(neznaykaCharacter.goLookingFor(kozlikCharacterImpl, bridgeLocation));
            } catch (CharacterMovementException charMoveExc) {
                System.out.println("Character can`t move here");
                System.exit(-342);
            }
        }

        currentTime.setCurrentTime(Time.DAYEND.getValue());
        bridgeLocation.setBias(.15); // lights on

        Shorties manyShorties = new Shorties() {

            private ArrayList<ICharacter> shorties = new ArrayList<ICharacter>();
            private ITimeContainer currentTime;
            private double ustalast = 0.0;
            private boolean areSleeping = false;

            @Override
            public void timeUpdater(ITimeContainer currentTime) {
                this.ustalast = Math.tanh(currentTime.getCurrentTime()*3.5 - 2 ) * .5 + .6;
                if (this.ustalast > .6 & !this.areSleeping) {
                    for (ICharacter s : this.shorties) {
                        this.goSleeping(s);
                    }
                    this.areSleeping = (this.areSleeping == false) ? true : false;
                }
            }

            @Override
            public ITimeContainer getCurrentTime() {
                return this.currentTime;
            }

            @Override
            public void setCurrentTime(ITimeContainer time) throws CharacterMovementException {
                this.currentTime = time;
                this.shorties = new ArrayList<>( 
                            Arrays.asList(
                                    new Character("Миллиончик", shelterLocation, this.currentTime),
                                    new Character("Пузырь", shelterLocation, this.currentTime) 
                                )
                            );
            }

			@Override
			public void goSleeping(ICharacter c) {
                System.out.println(c.getName() + "go Zzz with " + 
                                    new TrashChest( c.getName() == "Пузырь" ? Trash.RUBBER_PILLOW : Trash.OLD_MATTRESS ).makeSleepingPlaceFrom() );
			}

        };

        manyShorties.setCurrentTime(currentTime);
        time.addObjects2Update(manyShorties);

        for (; currentTime.getCurrentTime() < Time.FULLDAY.getValue(); currentTime.addToCurrentTime(200)) {
            time.timeStep();
        }

        System.out.println("\n");
        
        System.out.println("[STORYEND]");

        System.out.println("Neznayka`s " + neznaykaCharacter.toString());
        System.out.println("Neznayka`s Hashcode " + neznaykaCharacter.hashCode());
    }
}
