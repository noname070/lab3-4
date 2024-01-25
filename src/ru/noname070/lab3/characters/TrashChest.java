package ru.noname070.lab3.characters;


import java.util.Random;

public final class TrashChest {

    // Q: почему бы его не вынести в отдельный файл, в пакет types или enums
    // A: inner class по условию задачи

    public enum Trash {
        RUBBER_PILLOW,
        OLD_MATTRESS,
        CLOTH;
        
        private static Random rnd = new Random();

        public static Trash getRandomTrash() {
            Trash[] items = values();
            return items[rnd.nextInt(items.length)];
        }
    }

    private final Trash trashType;

    public TrashChest(Trash trashType) {
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
