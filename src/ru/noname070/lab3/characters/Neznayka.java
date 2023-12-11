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
        } else {return "Character " + this.getName() +  " too hungry";}
    }

    public String goLookingFor(CharacterImpl targetCharacter, LocationImpl targetLocation) {
        joinLocation(targetLocation);
        for (CharacterImpl suspectCharacter : targetLocation.getAllVisitors()) {
            if (suspectCharacter.equals(targetCharacter)) {
                return "wow! it`s a " + targetCharacter.getName() + " in " + targetLocation.getName();
            } else { return "oh noo it`s a " + suspectCharacter.getName() + " in " + targetLocation.getName();}
        }
        return null; // for vscode
    }

    public void hungerStiffle() {
        hungerScore = 40;
        thoughts.clear();
        thoughts.addAll(Arrays.asList("Куда же запропастился Козлик?", "Почему он не возвращается?"));


    }
    
}
