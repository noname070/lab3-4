package ru.noname070.lab3.characters;

import java.util.ArrayList;
import java.util.Arrays;

import ru.noname070.lab3.locations.LocationImpl;
import ru.noname070.lab3.stiffleActions.StiffleActions;

public class Neznayka extends CharacterImpl {
    private ArrayList<String> thoughts = new ArrayList<String>();
    private int hungerScore = 100;

    public Neznayka(String name, LocationImpl location) {
        super(name, location);
        thoughts.addAll(Arrays.asList(
        "Воспоминание о Пончике", "Ракета", "Луна", "Скоро поспеет помощь"));

    }

    public String divertHunger() {
        if (hungerScore > 10) {
            hungerScore -= 1;
            StiffleActions stiffleActionToDo = StiffleActions.getRandomAction();
            String result = StiffleActions.doAction(stiffleActionToDo);
            return result;
        } else {return "Character too hungry";}
    }

    public String goLookingFor(CharacterImpl targetCharacter, LocationImpl targetLocation) {
        joinLocation(targetLocation);
        if (targetLocation.isCharacterInLocation(targetCharacter)) {
            return "ура победа " + targetCharacter.getName() + " нашелся";
        } else { return "это не " + targetCharacter.getName(); }
    }

    public void hungerStiffle() {
        hungerScore = 40;
        thoughts.clear();
        thoughts.addAll(Arrays.asList("Куда же запропастился Козлик?", "Почему он не возвращается?"));


    }
    
}
