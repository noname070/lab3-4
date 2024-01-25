package ru.noname070.lab3.time;

import java.util.ArrayList;

import ru.noname070.lab3.entity.ITimeSlaveEntity;

public class GlobalTimeUpdater implements ITimeUpdater {
    private CurrentTimeContainer currentTime;
    private ArrayList<ITimeSlaveEntity> objects2update = new ArrayList<ITimeSlaveEntity>();

    public GlobalTimeUpdater(CurrentTimeContainer currentTime, ITimeSlaveEntity...objects2update){
        this.currentTime = currentTime;
        // this.objects2update.addAll();
        for (ITimeSlaveEntity o : objects2update) {
            this.objects2update.add(o);
        }
    }

    @Override
    public void timeStep() {
        for(ITimeSlaveEntity slave : objects2update) {
            slave.timeUpdater(currentTime);
        }
    }

    @Override
    public void addObjects2Update(ITimeSlaveEntity...anyObjects) {
        for (ITimeSlaveEntity o : anyObjects) {
            this.objects2update.add(o);
        }
    }
    
}
