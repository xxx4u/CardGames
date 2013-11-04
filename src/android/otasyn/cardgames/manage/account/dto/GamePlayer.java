/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.dto;

public class GamePlayer extends SimpleUser {

    private Game game;
    private Boolean accepted;

    public GamePlayer() { }

    public GamePlayer(final Integer id, final Game game) {
        setId(id);
        this.game = game;
    }

    public GamePlayer(final SimpleUser gamePlayer) {
        super(gamePlayer);
    }

    public GamePlayer(final SimpleUser gamePlayer, final Game game, final Boolean accepted) {
        super(gamePlayer);
        this.game = game;
        this.accepted = accepted;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(final Game game) {
        this.game = game;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(final Boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GamePlayer that = (GamePlayer) o;

        if (this.getId() != null ? !this.getId().equals(that.getId()) : that.getId() != null) return false;
        return (game != null ? game.equals(that.game) : that.game == null);
    }

    @Override
    public int hashCode() {
        return game != null ? game.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GamePlayer{" +
                "id=" + getId() +
                ", firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", enabled=" + getEnabled() +
                ", game=" + game +
                ", accepted=" + accepted + '\'' +
                '}';
    }
}
