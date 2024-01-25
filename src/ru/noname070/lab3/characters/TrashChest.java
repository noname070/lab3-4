package ru.noname070.lab3.characters;

import ru.noname070.lab3.entity.Entity;
import java.util.Random;

public class TrashChest extends Entity {

    public enum Trash {
        RUBBER_PILLOW("РЕЗИНОВЫЕ ПОДУШЕЧКИ"),
        OLD_MATTRESS("СТАРЫЕ ДВА МАТРАСИКА"),
        CLOTH("ПАКЕТ РВАНОЙ ОДЕЖДЫ");
        
        private static Random rnd = new Random();
        private String x;

        Trash(String x) {
            this.x = x;
        }

        public static Trash getRandomTrash() {
            Trash[] items = values();
            return items[rnd.nextInt(items.length)];
        }
    }

    private Trash trashType;

    public TrashChest(Trash trashType) {
        super(trashType.name());
        this.trashType = trashType;
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
