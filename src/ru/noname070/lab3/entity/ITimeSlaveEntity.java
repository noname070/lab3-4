package ru.noname070.lab3.entity;

import ru.noname070.lab3.exceptions.CharacterMovementException;
import ru.noname070.lab3.time.ITimeContainer;

public interface ITimeSlaveEntity {
    void timeUpdater(ITimeContainer currentTime);

    void setCurrentTime(ITimeContainer time) throws CharacterMovementException;
}
