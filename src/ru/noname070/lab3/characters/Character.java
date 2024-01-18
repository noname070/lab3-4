package ru.noname070.lab3.characters;

import java.util.ArrayList;


import ru.noname070.lab3.entity.Entity;
import ru.noname070.lab3.locations.LocatableHistory;
import ru.noname070.lab3.locations.СharacterLocatableImpl;
import ru.noname070.lab3.stiffleActions.StiffleActions;
import ru.noname070.lab3.time.CurrentTimeContainer;

public class Character extends Entity.TimeSlaveEntity implements ICharacter {
    private String name;
    private СharacterLocatableImpl currnetLocation;
    private int hungerScore; 
    private ArrayList<String> thoughts = new ArrayList<String>();
    private CurrentTimeContainer currentTime;

    public class TrashChest extends Entity {
        public static enum Trash {
            RUBBER_PILLOW("РЕЗИНОВЫЕ ПОДУШЕЧКИ"),
            OLD_MATTRESS("СТАРЫЕ ДВА МАТРАСИКА"),
            CLOTH("ПАКЕТ РВАНОЙ ОДЕЖДЫ");
            
            public String x;
            Trash(String x) {
                this.x = x;
            }
        }

        String name;
        Trash trashType;
        public TrashChest(Trash trashType) {
            this.trashType = trashType;
            this.name = trashType.x;
        }

        public String getName() {
            return name;
        }
 
        public String makeSleepingPlaceFrom() {
            switch (this.trashType) {
                case RUBBER_PILLOW:
                    
                    return "blowing rubber pads";

                case OLD_MATTRESS:

                    return "covered himself with two mattresses";

                case CLOTH:

                    return "wrapped himself in stuff like he had a cool sleeping bag";
            
                default:
                    return "made a decent sleeping space out of this crap";
            }
        }
    }


    public Character(String name, СharacterLocatableImpl location, CurrentTimeContainer currentTime) {
        this.name = name;
        this.hungerScore = 100;
        location.joinCharacter(this);
        this.currnetLocation = location;
        this.currentTime = currentTime;

    }

    public Character(String name, СharacterLocatableImpl location, ArrayList<String> thoughts, CurrentTimeContainer currentTime) {
        this.name = name;
        this.hungerScore = 100;
        location.joinCharacter(this);
        this.currnetLocation = location;
        this.currentTime = currentTime;

        this.thoughts = thoughts;
        System.out.println(thoughts);

    }

    // public Character(СharacterLocatableImpl location, CurrentTimeContainer currentTime, String...names) {
        
    // }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void joinLocation(СharacterLocatableImpl l) {
        currnetLocation.leaveCharacter(this);
        currnetLocation = l;
        l.joinCharacter(this);
    }

    @Override
    public СharacterLocatableImpl getCurrentLocation() {
        return this.currnetLocation;
    }

    public ArrayList<String> getThoughts () {
        return thoughts;
    }


    public String goLookingFor(Character targetCharacter, СharacterLocatableImpl targetLocation) {
        joinLocation(targetLocation);
        for (Character suspectCharacter : targetLocation.getAllVisitors()) {
            if (suspectCharacter.equals(targetCharacter)) {
                return "wow! " + this.getName()  + " succumbed that it`s a " + targetCharacter.getName() + " in " + targetLocation.getName();
            } else { return "oh noo "+ this.getName() + " succumbed that it`s a " + suspectCharacter.getName() + " in " + targetLocation.getName();}
        }
        return null; // for vscode
    }

    public Boolean goLookingFor(Character targetCharacter) {
        for (Character suspectCharacter : targetCharacter.currnetLocation.getAllVisitors()) {
            if (suspectCharacter.equals(targetCharacter)) {
                return true;
            } else { return false;}
        }
        return null; // for vscode
    }


    public String divertHunger() {
        if (hungerScore > 10 && hungerScore < 50) {
            hungerScore -= 1;
            StiffleActions stiffleActionToDo = StiffleActions.getRandomAction();
            String result = StiffleActions.doAction(stiffleActionToDo);
            return this.getName() + " " + result;
        } else {return "Character " + this.getName() +  " too hungry";}

    }
    
    public String hungerStiffle(ArrayList<String> newThoughts) {
        hungerScore = 49;
        thoughts.clear();
        thoughts = newThoughts;
        return this.getName() + " now starving by hunger\n"+newThoughts.toString();
    }

    // public ArrayList<LocatableHistory> getLocationHistory(Character c) {
    //     ArrayList<LocatableHistory> currentCharacterHistory = new ArrayList<LocatableHistory>();
    //     for (LocatableHistory r : c.currnetLocation.getHistory()) {
    //         if (r.character() == c ) {
    //             currentCharacterHistory.add(r);
    //         }
    //     }

    //     return currentCharacterHistory;

    // }

    @Override
    public void timeUpdater(CurrentTimeContainer currentTime) {
        if (hungerScore < 50) {
            System.out.println(divertHunger());
        }
    }


}
