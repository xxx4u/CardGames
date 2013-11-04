/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.dto;

public class Friend extends SimpleUser {

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

    private boolean confirmed;

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
