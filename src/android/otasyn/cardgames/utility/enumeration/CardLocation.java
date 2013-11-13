/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.utility.enumeration;

public enum CardLocation {
    LOCATION_46x64("gfx/cards/png/spritesheets/46x64/"),
    LOCATION_92x128("gfx/cards/png/spritesheets/92x128/"),
    LOCATION_184x256("gfx/cards/png/spritesheets/184x256/"),
    LOCATION_FULL("gfx/cards/png/spritesheets/full-size/");

    private final String location;

    private CardLocation(final String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
