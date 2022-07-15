package ssh.keyword;

import init.Display;
import ssh.Operation;
import ssh.SelfOperation;
import ssh.config.Context;

import java.util.Map;

public class SetDisplay implements Display {

    private Context context;
    private NumberGenerate numberGenerate ;

    public SetDisplay(Context context, NumberGenerate numberGenerate) {
        this.context = context;
        this.numberGenerate = numberGenerate;
    }

    @Override
    public void run(String str) {
        String[] sequence = str.split(" ");
        if (sequence.length <= 1) {
            System.out.println("没有指令");
            return ;
        }
        String result = "";
        for (int i = 1; i < sequence.length; i++) {
            result += " ";
            result += sequence[i];
        }
        context.putOperation(numberGenerate.get(), new SelfOperation(result));
    }

    @Override
    public String desc() {
        return "set 设置单步操作，这时候命令不会执行，如：set pwd ";
    }
}
