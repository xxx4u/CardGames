/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.utility.enumeration;

public enum CardFile {
    FILE_46x64("all-packed.xml"),
    FILE_92x128("all-packed.xml"),
    FILE_184x256_CLUBS("clubs-packed.xml"),
    FILE_184x256_DIAMONDS("diamonds-packed.xml"),
    FILE_184x256_HEARTS("hearts-packed.xml"),
    FILE_184x256_SPADES("spades-packed.xml"),
    FILE_184x256_BACKS("backs-packed.xml"),
    FILE_FULL_CLUBS_NUMBERED("clubs-numbered-packed.xml"),
    FILE_FULL_CLUBS_LETTERED("clubs-lettered-packed.xml"),
    FILE_FULL_DIAMONDS_NUMBERED("diamonds-numbered-packed.xml"),
    FILE_FULL_DIAMONDS_LETTERED("diamonds-lettered-packed.xml"),
    FILE_FULL_HEARTS_NUMBERED("hearts-numbered-packed.xml"),
    FILE_FULL_HEARTS_LETTERED("hearts-lettered-packed.xml"),
    FILE_FULL_SPADES_NUMBERED("spades-numbered-packed.xml"),
    FILE_FULL_SPADES_LETTERED("spades-lettered-packed.xml"),
    FILE_FULL_BACKS("backs-packed.xml");

    private final String file;

    private CardFile(final String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }
}
