package ru.noname070.lab3.entity;

import java.lang.reflect.Method;
import java.util.Objects;

public abstract class Entity {

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