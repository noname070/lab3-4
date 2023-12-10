package ru.noname070.lab3.characters;

import ru.noname070.lab3.Entity;
import ru.noname070.lab3.locations.LocationImpl;

public class CharacterImpl extends Entity implements Character {
    private String name;
    private LocationImpl currnetLocation;

    public CharacterImpl(String name, LocationImpl location) {
        this.name = name;
        location.joinCharacter(this);
        this.currnetLocation = location;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void joinLocation(LocationImpl l) {
        currnetLocation.leaveCharacter(this);
        currnetLocation = l;
        l.joinCharacter(this);
    }

    @Override
    public LocationImpl getCurrentLocation() {
        return this.currnetLocation;
    
    }
}
