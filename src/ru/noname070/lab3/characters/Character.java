package ru.noname070.lab3.characters;

import java.util.ArrayList;
import java.util.Objects;

import ru.noname070.lab3.characters.dialog.*;
import ru.noname070.lab3.entity.Entity;
import ru.noname070.lab3.exceptions.CharacterMovementException;
import ru.noname070.lab3.locations.ICharacterLocatable;
import ru.noname070.lab3.stiffleActions.StiffleActions;
import ru.noname070.lab3.time.ITimeContainer;

public class Character extends Entity.TimeSlaveEntity implements ICharacter, IDialog {
    private final ICharacterLocatable currnetLocation;
    private int hungerScore = 100;
    private ArrayList<String> thoughts = new ArrayList<>();

    public Character(String name, ICharacterLocatable location, ITimeContainer currentTime)
            throws CharacterMovementException {
        super(name, currentTime);
        location.joinCharacter(this);
        this.currnetLocation = location;

    }

    public Character(String name, ICharacterLocatable location, ArrayList<String> thoughts, ITimeContainer currentTime)
            throws CharacterMovementException {
        this(name, location, currentTime);
        this.thoughts = thoughts;

    }

    public void joinLocation(ICharacterLocatable l) throws CharacterMovementException {
        currnetLocation.leaveCharacter(this);
        l.joinCharacter(this);
    }

    public ICharacterLocatable getCurrentLocation() {
        return this.currnetLocation;
    }

    @Override
    public ArrayList<String> getThoughts() {
        return thoughts;
    }

    public void goLookingFor(ICharacter targetCharacter, ICharacterLocatable targetLocation)
            throws CharacterMovementException {
        joinLocation(targetLocation);
        for (ICharacter suspectCharacter : targetLocation.getAllVisitors()) {
            if (suspectCharacter.equals(targetCharacter)) {
                System.out.printf("wow! %s succumbed that it`s a %s in %s%n", this.getName(),
                        targetCharacter.getName(), targetCharacter.getName());
            } else
                System.out.printf("oh noo %s succumbed that it`s a %s in %s%n", this.getName(),
                        suspectCharacter.getName(), targetLocation.getName());
        }
    }

    @Override
    public String divertHunger() {
        if (hungerScore > 10 && hungerScore < 50) {
            hungerScore -= 1;
            String result = StiffleActions.getRandomAction().actionDescription();
            return String.format("character %s %s", this.getName(), result);
        } else if (hungerScore != 0) {
            hungerScore = 0;
            return String.format("character %s too hungry", this.getName());
        } else {
            return null; // for vs code
        }

    }

    @Override
    public String hungerStiffle(ArrayList<String> newThoughts) {
        hungerScore = 40;
        thoughts.clear();
        thoughts = newThoughts;
        return String.format("%s now starving by hunger\n%s", this.getName(), newThoughts.toString());
    }

    @Override
    public void timeUpdater(ITimeContainer currentTime) {
        if (hungerScore < 50) {
            System.out.println(divertHunger());
        }
    }

    @Override
    public int hashCode() {
        return this.currnetLocation.getName().hashCode() * this.hungerScore
                * this.getThoughts().toString().hashCode() * this.getName().hashCode();
    }

    @Override
    public String toString() {
        return String.format(
                "object Character; name:%s; currntLocation:%s, currentTime:%s, hungerScore:%s, thoughts:%s",
                this.getName(), this.getCurrentLocation().getName(), this.getCurrentTime().getCurrentTime(),
                this.hungerScore, this.getThoughts().toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;

        Character otherCharacter = (Character) obj;
        if (!Objects.equals(this.getName(), otherCharacter.getName()))
            return false;
        if (this.getCurrentLocation() != otherCharacter.getCurrentLocation())
            return false;
        if (this.hungerScore != otherCharacter.hungerScore)
            return false;
        return this.thoughts == otherCharacter.thoughts;
    }

    @Override
    public void say(String form, ICharacter target) {
        System.out.printf("%s say to %s : \"%s\"%n",
                this.getName(), target.getName(), form);

        ((IDialog) target).hear(form, this);
    }

    @Override
    public void hear(String form, ICharacter from) {
        System.out.printf("I (%s) hear this : \"%s\"\n%n",
                this.getName(), form);
    }

}
