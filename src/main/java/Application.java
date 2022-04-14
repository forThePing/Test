import http.HttpCommandFactory;
import init.Register;
import init.Command;
import init.CommandFactory;
import ssh.Login;
import ssh.SSHCommandFactory;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) throws Exception {
        //Pattern pattern = Pattern.compile("^\\$.*\\$$");
        //Matcher matcher = pattern.matcher("$aba$");
        //System.out.println(matcher.find());
        // ssh();
        http();
    }
    private static void http() throws Exception {
        Login login = new Login( "ez2qllQgE4Cn005+OL7ICgQfnd5DyONtM3pau5IOrpqChtXDsJUPuCd6CtYMgpigfKJMpwtqgSDapDwHx+r6ZjkMr9fVox66doq1AWq7bq+50AFwqTTWC7e4k9v3qX+4YiJlCttwB4fA+LFGVigsUfTfm2OzuMLOZHX2UlLRAJI=,C4a4qotav7a+Ko7zzjmqfGJ7BQN5snvbw8bpX+Rq3j2yOtAE7dpc8+WHJGyOE/ZOHyrFWukEChL9GCOJduCJvA+Lse9ddiVA44QDDAm91qxOYbSrKSxL9JjOE6xyeEuSPlrZi6t7w8fAjJroZrXWbW9wL+AWbu9MqVcL739XPWo=,WMYjOYMzXOt/QUEGy3kGAhBC1t2xtyJWw1v8kzT5MTW0+HtJ/NQDqXmopoQWkEVHUtMlr0U5SX9x60wIg0upsft60bJvShUrILHnP9aX8x1HQnHGSKusO6gDPbFN/TXv/x3zlE6X5b6QPsEtmOE6zmBbeHyssPoO3w8E6hEvSNc=,L2Rt+89EzMLW6oP3s+F0xdw5/059pTIIZC9nb7cViwwR1Ry4OEifCUxat5gzgjcgrgrRHshYbvkJ84vK4wr0Zqy3AnhDFIFq1drDMoEyyJzBCVVnhrYIEJUiYSWu8W4aJdCM1qBfeFgYgo+dZlpyLlRM6O3Dz58Fos9s2jWcfq4=,G1HIiI+Rjl6GWD/SRfwf26h/uM/r0Wla12UNDRTUPPXJ5vcsG//bqz05eDuJzALn9Oibt3KU1FD2iLo1jab+IY6ReCqvTXR8+oaFslCcYwFuOGQCjQam4QIKbmaoDuAIL6mfLKWGJLwTvcpIGQ9slmfA9FNW0oMqpvrk5tWEQfM=");
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
