import http.HttpCommandFactory;
import init.Register;
import init.Command;
import init.CommandFactory;
import ssh.Login;
import ssh.SSHCommandFactory;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws Exception {
       // ssh();
        http();
    }
    private static void http() throws Exception {
        Login login = new Login( "token");
        CommandFactory factory = new HttpCommandFactory();
        service(factory,login);
    }
    private static void ssh() throws Exception {
        Login login = new Login("***.***.***.***", "******", "****");
        CommandFactory factory = new SSHCommandFactory();
        service(factory,login);
    }
    private static void service(CommandFactory factory,Login login) throws Exception{
        Command command = factory.createCommand(login);
        Register register = factory.createRegister(command);
        register.init();

        command.connect();
        Scanner scanner = new Scanner(System.in);
        register.scanner("help");
        while (true) {
            String str = scanner.nextLine();
            register.scanner(str);
        }
    }
}
