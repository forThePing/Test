package ssh;


import init.Command;
import init.CommandFactory;
import init.Register;

public class SSHCommandFactory  implements CommandFactory {
    @Override
    public Command createCommand(Login login) {
        return new SshCommand(login.getHost(),login.getPort(),login.getUserName(),login.getPassWord());
    }

    @Override
    public Register createRegister(Command command) {
        return new SSHRegister(command);
    }
}
