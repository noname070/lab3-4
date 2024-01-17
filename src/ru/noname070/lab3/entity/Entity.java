package ru.noname070.lab3.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import ru.noname070.lab3.time.CurrentTimeContainer;

public abstract class Entity {

    public static abstract class TimeSlaveEntity extends Entity {
        abstract public void timeUpdater(CurrentTimeContainer currentTime);
        
    }

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

    private static String prepareMethod(Method method) {
        String name = method.getName().toString();
        String params = "";
        for (Class<?> p : method.getParameterTypes()) {
            params += p.getCanonicalName() + ", ";
        }
        String except = "";
        for (Class<?> e : method.getExceptionTypes()) {
            except += e.getName();
        }
        String ret = method.getReturnType().toString();
        

        return name + "("+params+") " + (except.length() == 0 ? "" : "throws " + except + " " ) + "-> " + ret   ;
    }

    @Override
    public String toString() {


        String M = Arrays.stream( this.getClass().getMethods() )
                        // .map( method -> method.getName().toString() )
                        .map( method -> Entity.prepareMethod(method))
                        .collect(Collectors.joining(";\n"));
        

        int idx = this.getClass().getName().lastIndexOf(".");
        return this.getClass().getName().substring(idx+1) + " methods: " + M + ", fields: NaN";

    }


}