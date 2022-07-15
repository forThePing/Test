package ssh.keyword;

import init.Display;
import ssh.config.Context;

public class ResetDisplay implements Display {
    private Context context;

    public ResetDisplay(Context context) {
        this.context = context;
    }

    @Override
    public void run(String str) {
        context.forEachOperation((key, operation)->{
            operation.reset();
        });
    }

    @Override
    public String desc() {
        return "reset 执行run命令后，单步操作有绑定状态，该命令可恢复所有命令为单步操作";
    }
}
