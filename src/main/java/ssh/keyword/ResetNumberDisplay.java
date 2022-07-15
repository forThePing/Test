package ssh.keyword;

import init.Display;
import ssh.Operation;
import ssh.config.Context;

import java.util.HashMap;
import java.util.Map;

public class ResetNumberDisplay implements Display {

    private Context context;

    public ResetNumberDisplay(Context context ) {
        this.context = context;

    }

    @Override
    public void run(String str) throws Exception {
        context.resetNumber();
    }

    @Override
    public String desc() {
        return "resetNumber 重置单步命令序列";
    }
}
