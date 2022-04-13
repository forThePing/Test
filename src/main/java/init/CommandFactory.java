package init;


import ssh.Login;

public interface CommandFactory {
    Command createCommand(Login login);
    Register createRegister(Command command);
}
