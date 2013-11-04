/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.dto;

public class NewUser extends SimpleUser {

    public NewUser() { }

    public NewUser(final SimpleUser friend, final String password) {
        setId(friend.getId());
        setEmail(friend.getEmail());
        setFirstname(friend.getFirstname());
        setLastname(friend.getLastname());
        setEnabled(friend.getEnabled());
        setPassword(password);
    }

    private String password;

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
