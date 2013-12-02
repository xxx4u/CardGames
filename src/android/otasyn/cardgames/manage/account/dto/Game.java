/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.dto;

import android.os.Parcel;
import android.os.Parcelable;
import android.otasyn.cardgames.manage.account.enumeration.GameType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Game implements Parcelable {

    private Integer id;
    private Boolean currentUserIsOwner;
    private SimpleUser owner;
    private GameType gameType = GameType.UNKNOWN;
    private UUID uuid;
    private Boolean started;
    private List<GamePlayer> turnOrder;
    private Date dateAdded;
    private Set<GamePlayer> players;
    private Map<Integer,GamePlayer> playerMap;
    private Boolean currentUserAccepted;

    public Game() { }

    public Game(final Integer id) {
        this.id = id;
    }

    public Game(final Parcel in) {
        id = in.readInt();
        currentUserIsOwner = in.readByte() != 0;
        owner = in.readParcelable(SimpleUser.class.getClassLoader());
        gameType = GameType.findGameType(in.readInt());
        String uuidString = in.readString();
        if (uuidString != null) {
            uuid = UUID.fromString(uuidString);
        }
        started = in.readByte() != 0;
        in.readTypedList(getTurnOrder(), GamePlayer.CREATOR);
        long epoch = in.readLong();
        if (epoch < 0) {
            dateAdded = new Date(epoch);
        }
        players = new HashSet<GamePlayer>(Arrays.asList(in.createTypedArray(GamePlayer.CREATOR)));
        playerMap = new HashMap<Integer, GamePlayer>(players.size());
        for (GamePlayer player : players) {
            playerMap.put(player.getId(), player);
        }
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeInt(id);
        dest.writeByte((byte) (Boolean.TRUE.equals(currentUserIsOwner) ? 1 : 0));
        dest.writeParcelable(owner, flags);
        dest.writeInt(gameType.getId());
        dest.writeString(uuid == null ? null : uuid.toString());
        dest.writeByte((byte) (Boolean.TRUE.equals(started) ? 1 : 0));
        dest.writeTypedList(turnOrder);
        dest.writeLong(dateAdded == null ? -1 : dateAdded.getTime());
        dest.writeTypedArray(players.toArray(new GamePlayer[players.size()]), flags);
    }

    public static final Parcelable.Creator<Game> CREATOR = new Parcelable.Creator<Game>() {
        @Override
        public Game createFromParcel(final Parcel source) {
            return new Game(source);
        }

        @Override
        public Game[] newArray(final int size) {
            return new Game[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Boolean getCurrentUserIsOwner() {
        return currentUserIsOwner;
    }

    public void setCurrentUserIsOwner(final Boolean currentUserIsOwner) {
        this.currentUserIsOwner = currentUserIsOwner;
    }

    public SimpleUser getOwner() {
        return owner;
    }

    public void setOwner(final SimpleUser owner) {
        this.owner = owner;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(final GameType gameType) {
        this.gameType = gameType;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(final UUID uuid) {
        this.uuid = uuid;
    }

    public Boolean getStarted() {
        return started;
    }

    public void setStarted(final Boolean started) {
        this.started = started;
    }

    public List<GamePlayer> getTurnOrder() {
        if (turnOrder == null) {
            turnOrder = new ArrayList<GamePlayer>();
        }
        return turnOrder;
    }

    public void setTurnOrder(final List<GamePlayer> turnOrder) {
        this.turnOrder = turnOrder;
    }

    public java.util.Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(final Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Set<GamePlayer> getPlayers() {
        if (players == null) {
            players = new HashSet<GamePlayer>();
        }
        return players;
    }

    public void setPlayers(final Set<GamePlayer> players) {
        this.players = players;
    }

    public Map<Integer, GamePlayer> getPlayerMap() {
        if (playerMap == null) {
            playerMap = new HashMap<Integer, GamePlayer>();
        }
        return playerMap;
    }

    public void setPlayerMap(final Map<Integer, GamePlayer> playerMap) {
        this.playerMap = playerMap;
    }

    public Boolean getCurrentUserAccepted() {
        return currentUserAccepted;
    }

    public void setCurrentUserAccepted(final Boolean currentUserAccepted) {
        this.currentUserAccepted = currentUserAccepted;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        return (id != null ? id.equals(game.id) : game.id == null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", owner=" + owner +
                ", gameType=" + gameType +
                ", uuid=" + uuid +
                ", started=" + started +
                '}';
    }
}
