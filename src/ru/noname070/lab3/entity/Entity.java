package ru.noname070.lab3.entity;

import java.lang.reflect.Field;
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
        String F = "";
         try {
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value;
                    value = field.get(this);
                if (value != null) {
                    F += field.getName() + "=" + value + ";";
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            } 

        return Objects.hash( F.hashCode() * Objects.hash(this.getClass()) );
    }

    @Override
    public String toString() {
        String M = "";
        String F = "";
        Method[] methods = this.getClass().getMethods();
        for (Method method : methods) {M += method.getName().toString() + ";";}
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value;
                    value = field.get(this);
                if (value != null) {
                    F += field.getName() + "=" + value + ";";
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            } 
        return "{"+ this.getClass() + "} methods: " + M + " fields: " + F;
    }

}