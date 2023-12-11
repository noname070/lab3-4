package ru.noname070.lab3;

import ru.noname070.lab3.characters.CharacterImpl;
import ru.noname070.lab3.characters.Neznayka;
import ru.noname070.lab3.locations.LocationImpl;
import ru.noname070.lab3.time.Time;

public class Story {
    public static void play() {
        int currentTime = Time.EVENING.getValue();
        LocationImpl shelterLocation = new LocationImpl("Убещише");
        LocationImpl bridgeLocation = new LocationImpl("Мост");
        LocationImpl unknowLocation = new LocationImpl("Неизвестнось");

        Neznayka neznaykaCharacter = new Neznayka("Незнайка", shelterLocation);
        CharacterImpl shortyCharacterImpl  = new CharacterImpl("Коротышка", bridgeLocation);
        CharacterImpl kozlikCharacterImpl = new CharacterImpl("Козлик", unknowLocation);

        neznaykaCharacter.hungerStiffle();

        while (true) {
            currentTime += 100;
            if (currentTime < Time.DAYEND.getValue()) {
                    neznaykaCharacter.divertHunger();
            } else {break;}
        }

        if (Time.DAYEND.getValue() == currentTime ) {
            neznaykaCharacter.goLookingFor(kozlikCharacterImpl, bridgeLocation);
        }
    }
}
