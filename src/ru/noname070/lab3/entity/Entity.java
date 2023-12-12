package ru.noname070.lab3.entity;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        String M = Arrays.stream( this.getClass().getMethods() )
                        .map( method -> method.getName().toString() )
                        .collect(Collectors.joining("; "));

        int idx = this.getClass().getName().lastIndexOf(".");
        return this.getClass().getName().substring(idx+1) + " methods: " + M + ", fields: NaN";

    }

}