package ValueObject;

public class UserData {
    private String PASSWORD;
    private String LOGIN;
    public UserData(String PASSWORD, String LOGIN){
        this.LOGIN = LOGIN;
        this.PASSWORD = PASSWORD;
    }
    public String getPassword(){
        return PASSWORD;
    }

    public String getLogin(){
        return LOGIN;
    }
}
