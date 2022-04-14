package init;


import ssh.Login;

public interface CommandFactory<T> {
    Command<T> createCommand(Login login);
    Register createRegister(Command<T> command);
}
