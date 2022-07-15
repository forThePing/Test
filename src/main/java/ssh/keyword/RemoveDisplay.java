package ssh.keyword;

import init.Display;
import ssh.Operation;
import ssh.config.Context;

import java.util.Map;

public class RemoveDisplay implements Display {

    private Context context;

    public RemoveDisplay(Context context) {
        this.context = context;
    }

    @Override
    public void run(String str) throws Exception {
        String[] sequence = str.split(" ");
        if (sequence.length <= 1) {
            System.out.println("没有要移除的命令");
            return;
        }
        String[] seq = sequence[1].split(",");
        for (String key : seq) {
            context.removeOperation(key);
        }
    }

    @Override
    public String desc() {
        return "remove 移除指定序列的单步命令";
    }
}
