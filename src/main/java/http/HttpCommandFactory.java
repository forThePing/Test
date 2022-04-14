package http;

import http.method.Method;
import init.Command;
import init.CommandFactory;
import init.Register;
import ssh.Login;

public class HttpCommandFactory implements CommandFactory<Method> {
    @Override
    public Command createCommand(Login login) {
        return new HttpCommand(login.getPassWord());
    }

    @Override
    public Register createRegister(Command<Method> command) {
        return new HttpRegister(command);
    }
}
