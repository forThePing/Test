package ssh.keyword;

import init.Command;
import init.Display;
import ssh.Operation;
import ssh.config.Context;
import ssh.parse.ResultParse;

import java.util.Map;

public class RunDisplay implements Display {

    private Command command;
    private Context context;

    private ResultParse logParse;


    public RunDisplay(Command command, Context context) {
        this.command = command;
        this.context = context;
    }

    public void setLogParse(ResultParse logParse) {
        this.logParse = logParse;
    }

    @Override
    public void run(String str) throws Exception {
        String[] sequence = str.split(" ");
        if (sequence.length <= 1) {
            System.out.println("没有选择组合");
            return;
        }
        String[] seq = sequence[1].split(",");
        Operation selfOperation = null;
        for (String key : seq) {
            Operation self = context.getOperation(key);
            if (self == null) {
                continue;
            }
            if (selfOperation != null) {
                self.setOperation(selfOperation);
            }
            selfOperation = self;
        }
        if (selfOperation == null) {
            System.out.println("没有要执行的命令");
            return;
        }
        if (!selfOperation.check()) {
            System.out.println("存在命令为空的操作");
            return;
        }
        String result = command.run(selfOperation.command());
        if (logParse == null) {
            System.out.println(result);
            return;
        }
        logParse.parse(result);
    }

    @Override
    public String desc() {
        return "run 真正执行命令时使用，形如 run 1,0 表示先执行1再执行0，01用逗号分隔，来源见show";
    }
}
