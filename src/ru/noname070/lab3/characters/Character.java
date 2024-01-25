package ru.noname070.lab3.characters;

import java.util.ArrayList;


import ru.noname070.lab3.entity.Entity;
import ru.noname070.lab3.exceptions.CharacterMovementException;
import ru.noname070.lab3.locations.IСharacterLocatable;
import ru.noname070.lab3.stiffleActions.StiffleActions;
import ru.noname070.lab3.time.ITimeContainer;

public class Character extends Entity.TimeSlaveEntity implements ICharacter {
    private IСharacterLocatable currnetLocation;
    private int hungerScore; 
    private ArrayList<String> thoughts = new ArrayList<String>();


    public Character(String name, IСharacterLocatable location, ITimeContainer currentTime) throws CharacterMovementException {
        super(name, currentTime);
        this.hungerScore = 100;
        location.joinCharacter(this);
        this.currnetLocation = location;

    }

    public Character(String name, IСharacterLocatable location, ArrayList<String> thoughts, ITimeContainer currentTime) throws CharacterMovementException {
        super(name, currentTime);
        this.hungerScore = 100;
        location.joinCharacter(this);
        this.currnetLocation = location;
        
        this.thoughts = thoughts;

    }

    @Override
    public void joinLocation(IСharacterLocatable l) throws CharacterMovementException {
        currnetLocation.leaveCharacter(this);
        l.joinCharacter(this);
    }

    @Override
    public IСharacterLocatable getCurrentLocation() {
        return this.currnetLocation;
    }

    @Override
    public ArrayList<String> getThoughts () {
        return thoughts;
    }


    public String goLookingFor(ICharacter targetCharacter, IСharacterLocatable targetLocation) throws CharacterMovementException {
        joinLocation(targetLocation);
        for (ICharacter suspectCharacter : targetLocation.getAllVisitors()) {
            if (suspectCharacter.equals(targetCharacter)) {
                return "wow! " + this.getName()  + " succumbed that it`s a " + targetCharacter.getName() + " in " + targetLocation.getName();
            } else { return "oh noo "+ this.getName() + " succumbed that it`s a " + suspectCharacter.getName() + " in " + targetLocation.getName();}
        }
        return null; // for vscode
    }

    @Override
    public Boolean goLookingFor(ICharacter targetCharacter) {
        for (ICharacter suspectCharacter : targetCharacter.getCurrentLocation().getAllVisitors()) {
            if (suspectCharacter.equals(targetCharacter)) {
                return true;
            } else { return false;}
        }
        return null; // for vscode
    }


    @Override
    public String divertHunger() {
        if (hungerScore > 10 && hungerScore < 50) {
            hungerScore -= 1;
            StiffleActions stiffleActionToDo = StiffleActions.getRandomAction();
            String result = StiffleActions.doAction(stiffleActionToDo);
            return this.getName() + " " + result;
        } else {return "Character " + this.getName() +  " too hungry";}

    }
    
    @Override
    public String hungerStiffle(ArrayList<String> newThoughts) {
        hungerScore = 40;
        thoughts.clear();
        thoughts = newThoughts;
        return this.getName() + " now starving by hunger\n"+newThoughts.toString();
    }

    @Override
    public void timeUpdater(ITimeContainer currentTime) {
        if (hungerScore < 50) {
            System.out.println(divertHunger());
        }
    }



}
