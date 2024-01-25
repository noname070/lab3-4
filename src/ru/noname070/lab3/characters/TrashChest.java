package ru.noname070.lab3.characters;

import ru.noname070.lab3.entity.Entity;
import java.util.Random;

public class TrashChest extends Entity {

    // TODO: почему бы его не вынести в отдельный файл, в пакет types или enums

    public enum Trash {
        RUBBER_PILLOW("РЕЗИНОВЫЕ ПОДУШЕЧКИ"),
        OLD_MATTRESS("СТАРЫЕ ДВА МАТРАСИКА"),
        CLOTH("ПАКЕТ РВАНОЙ ОДЕЖДЫ");
        
        private static Random rnd = new Random();
        // TODO: не используется
        private String x;

        Trash(String x) {
            this.x = x;
        }

        public static Trash getRandomTrash() {
            Trash[] items = values();
            return items[rnd.nextInt(items.length)];
        }
    }

    // TODO: final
    private Trash trashType;

    public TrashChest(Trash trashType) {
        super(trashType.name());
        this.trashType = trashType;
    }

    public String makeSleepingPlaceFrom() {
        return switch (this.trashType) {
            case RUBBER_PILLOW -> "blowing rubber pads";
            case OLD_MATTRESS -> "covered himself with two mattresses";
            case CLOTH -> "wrapped himself in stuff like he had a cool sleeping bag";
            default -> "made a decent sleeping space out of this crap";
        };
    }

}
