package ru.noname070.lab3.characters;

import java.lang.reflect.Method;
import java.util.Objects;

import ru.noname070.lab3.location.Location;

public abstract class Character {
    private String name;
    Location location;
    public int hunger = 100;
    public int patience = 100;

    abstract protected void callbackLowPatience();
    abstract protected void callbackLowHunger();

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toString());
    }

    @Override
    public String toString() {
        String S = "";
        Method[] methods = this.getClass().getMethods();
        for (Method method : methods) {S += method.getName().toString() + ";";}
        return "{"+ this.getClass() + "} methods: " + S;
    }
    
}