/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Message implements Parcelable {

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

    public Message(final Parcel in) {
        type = Type.valueOf(in.readString());
        message = in.readString();
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(type.toString());
        dest.writeString(message);
    }

    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {
        @Override
        public Message createFromParcel(final Parcel source) {
            return new Message(source);
        }

        @Override
        public Message[] newArray(final int size) {
            return new Message[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
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
