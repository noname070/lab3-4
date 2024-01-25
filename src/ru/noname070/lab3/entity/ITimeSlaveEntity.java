package ru.noname070.lab3.entity;

import ru.noname070.lab3.exceptions.CharacterMovementException;
import ru.noname070.lab3.time.ITimeContainer;

public interface ITimeSlaveEntity {
    // TODO: abstract лишнее
    abstract void timeUpdater(ITimeContainer currentTime);

    // TODO: не используется
    ITimeContainer getCurrentTime();

    void setCurrentTime(ITimeContainer time) throws CharacterMovementException;
}
