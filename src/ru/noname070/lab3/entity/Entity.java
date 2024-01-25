package ru.noname070.lab3.entity;

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

}