/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Game implements Serializable {

    private Integer id;
    private Boolean currentUserIsOwner;
    private SimpleUser owner;
    private GameType gameType;
    private UUID uuid;
    private Boolean started;
    private Date dateAdded;
    private Set<GamePlayer> players;

    public Game() { }

    public Game(final Integer id) {
        this.id = id;
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
