package ssh;

public class Login {
    private String host;
    private int port =22;
    private String userName;
    private String passWord;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public Login(String passWord) {
        this.passWord = passWord;
    }

    public Login(String host, String userName, String passWord) {
        this.host = host;
        this.userName = userName;
        this.passWord = passWord;
    }

    public Login(String host, int port, String userName, String passWord) {
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.passWord = passWord;
    }
}
