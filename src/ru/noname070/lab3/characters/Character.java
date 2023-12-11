package ru.noname070.lab3.characters;

import ru.noname070.lab3.locations.LocationImpl;

public interface Character {
    
    public String getName();
    public void joinLocation(LocationImpl l);
    public LocationImpl getCurrentLocation();

}
