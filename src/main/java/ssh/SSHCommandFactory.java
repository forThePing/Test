package ssh;


import init.Command;
import init.CommandFactory;
import init.Register;

public class SSHCommandFactory  implements CommandFactory<String> {
    @Override
    public Command<String> createCommand(Login login) {
        return new SshCommand(login.getHost(),login.getPort(),login.getUserName(),login.getPassWord());
    }

    @Override
    public Register createRegister(Command<String> command) {
        return new SSHRegister(command);
    }
}
