package ru.noname070.lab3.locations;

import ru.noname070.lab3.characters.Character;
import ru.noname070.lab3.time.Time;

public record LocatableHistory(Character character, СharacterLocatableImpl location, Time time, Status status) {}
