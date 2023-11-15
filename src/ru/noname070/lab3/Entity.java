package ru.noname070.lab3;

public interface Entity {
    
    @Override
    boolean equals(Object obj);
    
    @Override
    int hashCode();

    @Override
    String toString();
}
