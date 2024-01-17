package ru.noname070.lab3.time;

import ru.noname070.lab3.entity.Entity.TimeSlaveEntity;;

public class GlobalTimeUpdater {
    private CurrentTimeContainer currentTime;
    private TimeSlaveEntity[] objects2update;

    public GlobalTimeUpdater(CurrentTimeContainer currentTime, TimeSlaveEntity...objects2update){
        this.currentTime = currentTime;
        this.objects2update = objects2update;
    }

    public void timeStep() {
        for(TimeSlaveEntity slave : objects2update) {
            slave.timeUpdater(currentTime);
        }
    }
    
}
