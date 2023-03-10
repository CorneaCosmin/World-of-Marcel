package World_of_Marcel;

public class Credentials
{
    private String email;
    private String password;
    public Credentials(String email, String password)
    {
        this.email=email;
        this.password=password;
    }

    public void setEmail(String email)
    {
        this.email=email;
    }

    public void setPassword(String password)
    {
        this.password=password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
