package ssh.keyword;

import init.Command;
import init.Display;
import ssh.SelfOperation;

import java.util.Scanner;

public class LineDisplay implements Display {

    private Command command;

    public LineDisplay(Command command) {
        this.command = command;
    }

    @Override
    public void run(String str) throws Exception {
        Scanner scanner = new Scanner(System.in);
        SelfOperation now = null;
        String path;

        while (true){
             String text = scanner.nextLine();
             if (text.startsWith("cd ")) {
                 SelfOperation pwd = new SelfOperation("pwd");
                 SelfOperation operation = new SelfOperation(text);
                 pwd.setOperation(operation);
                 if (now != null) {
                     pwd.setOperation(operation);
                     operation.setOperation(now);
                 }
                 path = command.run(pwd.command());
                 now = new SelfOperation("cd " + path.replaceAll("\\s+",""));
                 continue;
             }

            if (text.startsWith("exit")) {
                break;
            }
            SelfOperation operation = new SelfOperation(text);
            if(now!=null){
                operation.setOperation(now);
            }
            System.out.println(command.run(operation.command()));
        }
    }

    @Override
    public String desc() {
        return "line 进入连续命令模式，可记录上下文";
    }
}
