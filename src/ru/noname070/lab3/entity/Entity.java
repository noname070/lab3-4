package ru.noname070.lab3.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import ru.noname070.lab3.time.ITimeContainer;

public abstract class Entity implements IEntity {

    private String name;


    public static abstract class TimeSlaveEntity extends Entity implements ITimeSlaveEntity {
        private ITimeContainer currentTime;
        
        public TimeSlaveEntity(String name, ITimeContainer time) {
            super(name);
            this.currentTime = time;
        }

        public ITimeContainer getCurrentTime() {return this.currentTime;}

        public void setCurrentTime(ITimeContainer time) {this.currentTime = time;}

        abstract public void timeUpdater(ITimeContainer currentTime);
        
    }

    public Entity (String name) {
        this.name = name;
    }

    public String getName() {return this.name;}

    public void setName(String name ) { this.name = name;}


    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode() ? true : false;
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
        } catch (IllegalAccessException e) {
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
        

        return this.getClass().getName() + " methods: " + M;

    }


}