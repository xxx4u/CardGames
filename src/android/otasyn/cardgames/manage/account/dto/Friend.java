/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Friend extends SimpleUser {

    private boolean confirmed;

    public Friend() { }

    public Friend(final Integer id) {
        setId(id);
    }

    public Friend(final SimpleUser friend) {
        super(friend);
    }

    public Friend(final SimpleUser friend, final boolean confirmed) {
        super(friend);
        setConfirmed(confirmed);
    }

    public Friend(final Parcel in) {
        super(in);
        confirmed = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        super.writeToParcel(dest, flags);
        dest.writeByte((byte) (confirmed ? 1 : 0));
    }

    public static final Parcelable.Creator<Friend> CREATOR = new Parcelable.Creator<Friend>() {
        @Override
        public Friend createFromParcel(final Parcel source) {
            return new Friend(source);
        }

        @Override
        public Friend[] newArray(final int size) {
            return new Friend[size];
        }
    };

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(final boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + getId() +
                ", firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", enabled=" + getEnabled() + '\'' +
                ", confirmed=" + confirmed +
                '}';
    }
}
