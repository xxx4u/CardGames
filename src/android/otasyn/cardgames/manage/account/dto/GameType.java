/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.dto;

import java.io.Serializable;

public class GameType implements Serializable {

    private int id;
    private String name;

    public GameType(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        if (name == null) {
            name = "";
        }
        return name;
    }

    public void setName(final String name) throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("Game name must not be null.");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("Game name must not be empty.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "GameType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
