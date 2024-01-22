package ru.noname070.lab3.time;

import java.util.ArrayList;


import ru.noname070.lab3.entity.Entity.TimeSlaveEntity;;

public class GlobalTimeUpdater implements ITimeUpdater {
    private CurrentTimeContainer currentTime;
    private ArrayList<TimeSlaveEntity> objects2update = new ArrayList<TimeSlaveEntity>();

    public GlobalTimeUpdater(CurrentTimeContainer currentTime, TimeSlaveEntity...objects2update){
        this.currentTime = currentTime;
        // this.objects2update.addAll();
        for (TimeSlaveEntity o : objects2update) {
            this.objects2update.add(o);
        }
    }

    @Override
    public void timeStep() {
        for(TimeSlaveEntity slave : objects2update) {
            slave.timeUpdater(currentTime);
        }
    }

    @Override
    public void addObjects2Update(TimeSlaveEntity...anyObjects) {
        for (TimeSlaveEntity o : anyObjects) {
            this.objects2update.add(o);
        }
    }
    
}
