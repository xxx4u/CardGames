package android.otasyn.cardgames.database;

public class LoginInfo {

    private String email;
    private String password;

    public LoginInfo(final String email, final String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginInfo loginInfo = (LoginInfo) o;

        if (email != null ? !email.equals(loginInfo.email) : loginInfo.email != null) return false;
        if (password != null ? !password.equals(loginInfo.password) : loginInfo.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
