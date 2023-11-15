package ru.noname070.lab3;

import ru.noname070.lab3.characters.Neznayka;
import ru.noname070.lab3.characters.Shorty;
import ru.noname070.lab3.location.Bridge;
import ru.noname070.lab3.location.Location;
import ru.noname070.lab3.location.Shelter;
import ru.noname070.lab3.time.Time;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        Time currentTime = Time.MORNING; 

        Location bridgeLocation = new Bridge();
        Location shelterLocation = new Shelter();

        Neznayka neznaykaCharacter = new Neznayka();
        neznaykaCharacter.updateTime(currentTime);
        shelterLocation.join(neznaykaCharacter);
        
        currentTime = Time.NOON;
        neznaykaCharacter.updateTime(currentTime);
        // neznaykaCharacter.hungerStiffle();


        currentTime = Time.EVENING;
        Shorty shortyCharacter = new Shorty();
        bridgeLocation.join(shortyCharacter);

        neznaykaCharacter.updateTime(currentTime);
        if (neznaykaCharacter.getDecisionToLeave()) {
            
        }
        

    } 
}
