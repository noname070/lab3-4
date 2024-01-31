package ru.noname070.lab3.locations;

import java.util.ArrayList;

import ru.noname070.lab3.characters.ICharacter;
import ru.noname070.lab3.time.ITimeContainer;
import ru.noname070.lab3.exceptions.*;

import java.util.Objects;
import java.util.stream.Collectors;

public class CharacterLocatableImpl extends Location implements ICharacterLocatable {
    public CharacterLocatableImpl(String name, ITimeContainer currentTime) {
        super(name, currentTime);
    }

    public CharacterLocatableImpl(String name, ITimeContainer currentTime, double visibility_bias) {
        super(name, currentTime, visibility_bias);
    }

    private final ArrayList<ICharacter> visitors = new ArrayList<ICharacter>();

    @Override
    public ArrayList<ICharacter> getAllVisitors() {
        if (!visitors.isEmpty())
            return visitors;
        else
            throw new NoAnyVisitorsError("no any visitors in " + getName());
    }

    public boolean isCharacterInLocation(ICharacter c) {
        return visitors.contains(c);
    }

    @Override
    public void joinCharacter(ICharacter c) throws CharacterMovementException {
        if (!visitors.contains(c)) {
            visitors.add(c);
            System.out.printf("now %s joint to %s%n", c.getName(), this.getName());

        } else
            throw new CharacterMovementException(String.format("character %s can`t perform this move", c.getName()));
    }

    @Override
    public void leaveCharacter(ICharacter c) throws CharacterMovementException {
        if (visitors.contains(c)) {
            visitors.remove(c);
            System.out.printf("%s leaves from %s%n", c.getName(), this.getName());
        } else
            throw new CharacterMovementException("character " + getName() + "cat`t perform this move");

    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() * this.getAllVisitors().toString().hashCode()
                * this.getCurrentTime().getCurrentTime();
    }

    @Override
    public String toString() {
        String V = this.getAllVisitors().stream()
                .map(Object::toString)
                .collect(Collectors.joining(";\n"));

        return String.format("object CharacterLocatable; name:%s; currentTime:%s;\nvisitors: [ %s ]",
                this.getName(), this.getCurrentTime().getCurrentTime(), V);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;

        CharacterLocatableImpl otherLocatable = (CharacterLocatableImpl) obj;
        if (!Objects.equals(this.getName(), otherLocatable.getName()))
            return false;
        if (this.visitors != otherLocatable.visitors)
            return false;
        return this.getAllVisitors() == otherLocatable.getAllVisitors();
    }

}
