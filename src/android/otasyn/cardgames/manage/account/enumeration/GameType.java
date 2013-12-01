package android.otasyn.cardgames.manage.account.enumeration;

public enum GameType {
    UNKNOWN(0, "Unknown"),
    FREESTYLE(1, "Freestyle"),
    FIVES(2, "Fives");

    private final int id;
    private final String name;

    private GameType(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static GameType findGameType(final int id) {
        for (GameType gt : GameType.values()) {
            if (gt.getId() == id) {
                return gt;
            }
        }
        return UNKNOWN;
    }
}
