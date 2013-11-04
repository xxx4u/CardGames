/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.dto;

import java.io.Serializable;

public class Message implements Serializable {

    private Type type;
    private String message;

    public Message() { }

    public Message(final Type type) {
        this.type = type;
    }

    public Message(final Type type, final String message) {
        this.type = type;
        this.message = message;
    }

    public Type getType() {
        return type;
    }

    public void setType(final Type type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public enum Type {
        ERROR("error"),
        WARNING("warning"),
        SUCCESS("success");

        private final String type;

        Type(final String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
