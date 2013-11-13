/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.utility.enumeration;

public enum Background {
    BG_BLUE_0B4E66("blue-0b4e66.png"),
    BG_BLUE_0B2566("blue-0b2566.png"),
    BG_BLUE_27647A("blue-27647a.png"),
    BG_BROWN_7A4827("brown-7a4827.png"),
    BG_GREEN_1A9C48("green-1a9c48.png"),
    BG_MAGENTA_660b29("magenta-660b29.png"),
    BG_ORANGE_C47219("orange-c47219.png");

    public static String BG_BASE_PATH = "gfx/background/";

    private final String location;

    private Background(final String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }
}
