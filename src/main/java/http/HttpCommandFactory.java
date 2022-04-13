package http;

import init.Command;
import init.CommandFactory;
import init.Register;
import ssh.Login;

public class HttpCommandFactory implements CommandFactory {
    @Override
    public Command createCommand(Login login) {
        return new HttpCommand(login.getPassWord());
    }

    @Override
    public Register createRegister(Command command) {
        return new HttpRegister(command);
    }
}
