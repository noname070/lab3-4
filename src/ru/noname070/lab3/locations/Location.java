package ru.noname070.lab3.locations;

import ru.noname070.lab3.entity.Entity;

public class Location extends Entity implements ILocation {
    private String name;

    public Location(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass() ? this.name == ((Location)obj).name : false;
    }

} 