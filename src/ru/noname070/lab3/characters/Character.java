package ru.noname070.lab3.characters;

import java.util.ArrayList;

import ru.noname070.lab3.entity.Entity;
import ru.noname070.lab3.locations.СharacterLocatableImpl;
import ru.noname070.lab3.stiffleActions.StiffleActions;

public class Character extends Entity implements ICharacter {
    private String name;
    private СharacterLocatableImpl currnetLocation;
    private int hungerScore; 
    private ArrayList<String> thoughts = new ArrayList<String>();

    public Character(String name, СharacterLocatableImpl location) {
        this.name = name;
        this.hungerScore = 100;
        location.joinCharacter(this);
        this.currnetLocation = location;

    }

    public Character(String name, СharacterLocatableImpl location, ArrayList<String> thoughts) {
        this.name = name;
        this.hungerScore = 100;
        location.joinCharacter(this);
        this.currnetLocation = location;

        this.thoughts = thoughts;

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void joinLocation(СharacterLocatableImpl l) {
        currnetLocation.leaveCharacter(this);
        currnetLocation = l;
        l.joinCharacter(this);
    }

    @Override
    public СharacterLocatableImpl getCurrentLocation() {
        return this.currnetLocation;
    }

    public ArrayList<String> getThoughts () {
        return thoughts;
    }


    public String goLookingFor(Character targetCharacter, СharacterLocatableImpl targetLocation) {
        joinLocation(targetLocation);
        for (Character suspectCharacter : targetLocation.getAllVisitors()) {
            if (suspectCharacter.equals(targetCharacter)) {
                return "wow! it`s a " + targetCharacter.getName() + " in " + targetLocation.getName();
            } else { return "oh noo it`s a " + suspectCharacter.getName() + " in " + targetLocation.getName();}
        }
        return null; // for vscode
    }

    public String divertHunger() {
        if (hungerScore > 10) {
            hungerScore -= 1;
            StiffleActions stiffleActionToDo = StiffleActions.getRandomAction();
            String result = StiffleActions.doAction(stiffleActionToDo);
            return result;
        } else {return "Character " + this.getName() +  " too hungry";}
    }
    
    public void hungerStiffle(ArrayList<String> newThoughts) {
        hungerScore = 40;
        thoughts.clear();
        thoughts = newThoughts;
    }

}
