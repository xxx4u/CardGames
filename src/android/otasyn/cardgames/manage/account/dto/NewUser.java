/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class NewUser extends SimpleUser {

    private String password;

    public NewUser() { }

    public NewUser(final SimpleUser friend, final String password) {
        setId(friend.getId());
        setEmail(friend.getEmail());
        setFirstname(friend.getFirstname());
        setLastname(friend.getLastname());
        setEnabled(friend.getEnabled());
        setPassword(password);
    }

    public NewUser(final Parcel in) {
        super(in);
        password = in.readString();
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(password);
    }

    public static final Parcelable.Creator<NewUser> CREATOR = new Parcelable.Creator<NewUser>() {
        @Override
        public NewUser createFromParcel(final Parcel source) {
            return new NewUser(source);
        }

        @Override
        public NewUser[] newArray(final int size) {
            return new NewUser[size];
        }
    };

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "id=" + getId() +
                ", firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + password + '\'' +
                ", enabled='" + getEnabled() + '\'' +
                '}';
    }
}
