package Entity;

public class User{
    private String email;
    private String password;
    private String nickname;
    private String name;
    private String birthDate;
    public boolean isSame(User user) {
        return this.email.equals(user.email);
    }

}
