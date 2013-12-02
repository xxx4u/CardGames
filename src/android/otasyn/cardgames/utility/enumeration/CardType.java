/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.utility.enumeration;

public enum CardType {
    CLUBS_ACE(1,36,36,9,0),
    CLUBS_TWO(2,4,4,1,1),
    CLUBS_THREE(3,8,8,2,2),
    CLUBS_FOUR(4,12,12,3,3),
    CLUBS_FIVE(5,16,16,4,4),
    CLUBS_SIX(6,20,20,5,5),
    CLUBS_SEVEN(7,24,24,6,6),
    CLUBS_EIGHT(8,28,28,7,7),
    CLUBS_NINE(9,32,32,8,8),
    CLUBS_TEN(10,0,0,0,0),
    CLUBS_JACK(11,42,42,10,1),
    CLUBS_QUEEN(12,50,50,12,3),
    CLUBS_KING(13,46,46,11,2),
    DIAMONDS_ACE(14,37,37,9,0),
    DIAMONDS_TWO(15,5,5,1,1),
    DIAMONDS_THREE(16,9,9,2,2),
    DIAMONDS_FOUR(17,13,13,3,3),
    DIAMONDS_FIVE(18,17,17,4,4),
    DIAMONDS_SIX(19,21,21,5,5),
    DIAMONDS_SEVEN(20,25,25,6,6),
    DIAMONDS_EIGHT(21,29,29,7,7),
    DIAMONDS_NINE(22,33,33,8,8),
    DIAMONDS_TEN(23,1,1,0,0),
    DIAMONDS_JACK(24,43,43,10,1),
    DIAMONDS_QUEEN(25,51,51,12,3),
    DIAMONDS_KING(26,47,47,11,2),
    HEARTS_ACE(27,38,38,9,0),
    HEARTS_TWO(28,6,6,1,1),
    HEARTS_THREE(29,10,10,2,2),
    HEARTS_FOUR(30,14,14,3,3),
    HEARTS_FIVE(31,18,18,4,4),
    HEARTS_SIX(32,22,22,5,5),
    HEARTS_SEVEN(33,26,26,6,6),
    HEARTS_EIGHT(34,30,30,7,7),
    HEARTS_NINE(35,34,34,8,8),
    HEARTS_TEN(36,2,2,0,0),
    HEARTS_JACK(37,44,44,10,1),
    HEARTS_QUEEN(38,52,52,12,3),
    HEARTS_KING(39,48,48,11,2),
    SPADES_ACE(40,39,39,9,0),
    SPADES_TWO(41,7,7,1,1),
    SPADES_THREE(42,11,11,2,2),
    SPADES_FOUR(43,15,15,3,3),
    SPADES_FIVE(44,19,19,4,4),
    SPADES_SIX(45,23,23,5,5),
    SPADES_SEVEN(46,27,27,6,6),
    SPADES_EIGHT(47,31,31,7,7),
    SPADES_NINE(48,35,35,8,8),
    SPADES_TEN(49,3,3,0,0),
    SPADES_JACK(50,45,45,10,1),
    SPADES_QUEEN(51,53,53,12,3),
    SPADES_KING(52,49,49,11,2),
    BACK_BLUE(53,40,40,0,0),
    BACK_RED(54,41,41,1,1);

    private final int id;
    private final int id_46x64;
    private final int id_92x128;
    private final int id_184x256;
    private final int id_fullSize;

    private CardType(final int id, final int id_46x64, final int id_92x128, final int id_184x256, final int id_fullSize) {
        this.id = id;
        this.id_46x64 = id_46x64;
        this.id_92x128 = id_92x128;
        this.id_184x256 = id_184x256;
        this.id_fullSize = id_fullSize;
    }

    public int getId() {
        return id;
    }

    public int getId_46x64() {
        return id_46x64;
    }

    public int getId_92x128() {
        return id_92x128;
    }

    public int getId_184x256() {
        return id_184x256;
    }

    public int getId_fullSize() {
        return id_fullSize;
    }

    public static CardType findCard(final int id) {
        for (CardType card : CardType.values()) {
            if (card.getId() == id) {
                return card;
            }
        }
        return null;
    }
}
