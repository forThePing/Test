package ssh.keyword;

import init.Display;
import ssh.Operation;

import java.util.Map;

public class ResetDisplay implements Display {
    private Map<String, Operation> cache;

    public ResetDisplay(Map<String, Operation> cache) {
        this.cache = cache;
    }

    @Override
    public void run(String str) {
        cache.forEach((key,operation)->{
            operation.reset();
        });
    }

    @Override
    public String desc() {
        return "reset 执行run命令后，单步操作有绑定状态，该命令可恢复所有命令为单步操作";
    }
}
