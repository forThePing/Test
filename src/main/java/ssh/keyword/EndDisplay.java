package ssh.keyword;

import init.Command;
import init.Display;

public class EndDisplay implements Display {

    private Command command;

    public EndDisplay(Command command) {
        this.command = command;
    }
    @Override
    public void run(String str) {
        command.disconnect();
    }

    @Override
    public String desc() {
        return "end 断开ssh连接";
    }
}
