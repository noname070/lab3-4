package ru.noname070.lab3.characters;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import ru.noname070.lab3.actions.StifleActions;
import ru.noname070.lab3.location.Location;
import ru.noname070.lab3.time.Time;

public class Neznayka extends Character {
    private Time lastTime;
    private Time currentTime;
    public boolean decideToLeave = false;

    private ArrayList<String> thoughts = new ArrayList<String>()
    {{ add("Воспоминание о Пончике"); add("Ракета"); add("Луна"); add("Скоро поспеет помощь"); }};

    public void updateTime(Time updatedCurrentTime) throws InterruptedException {
        if (lastTime == null) {
            lastTime = updatedCurrentTime;
            currentTime = updatedCurrentTime;
        }
        else if (Time.getTimeDelta(lastTime, updatedCurrentTime) == 3500) {
            lastTime = currentTime;
            currentTime = updatedCurrentTime;
            hungerStiffle();
        }
        else if (Time.getTimeDelta(lastTime, updatedCurrentTime) == 2000) {
            lastTime = currentTime;
            currentTime = updatedCurrentTime;
        }
        
        this.currentTime = updatedCurrentTime;
    }
    
    public void searchCharacterAtLocation(Character c, Location l) {
        if (l.getAllVisitors().contains(c)) {
            decideToLeave = true;
        } else {
            decideToLeave = false;
        }
    }

    public boolean getDecisionToLeave() {
        return decideToLeave;
    }
    
    public void hungerStiffle () throws InterruptedException {
        hunger = 40;
        thoughts.clear();
        thoughts.add("Куда же запропастился Козлик?");
        thoughts.add("Почему он не возвращается?");

        System.out.println("Neznaka`s thoughts: " + thoughts.toString());

        for (int i=15; i > 0; i--) {
            if (hunger-- < 30) {
                callbackLowHunger();
            }
            TimeUnit.SECONDS.sleep((long) .2);
            
        }
    }

    @Override
    protected void callbackLowPatience() {
        System.out.println("Neznayka has low parience");
    }

    @Override
    protected void callbackLowHunger() {
        StifleActions randomAction = StifleActions.getRandomAction();
        patience-=15;
        System.out.println("Neznayka do " + randomAction);
        if (patience < 30) {
            callbackLowPatience();
        }
    }

}
