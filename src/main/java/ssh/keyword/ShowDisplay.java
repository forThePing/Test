package ssh.keyword;

import init.Display;
import ssh.Operation;

import java.util.Map;

public class ShowDisplay implements Display {
    private Map<String, Operation> cache;

    public ShowDisplay(Map<String, Operation> cache) {
        this.cache = cache;
    }

    @Override
    public void run(String str) {
        cache.forEach((key,operation)->{
            System.out.println(key + "：" + operation.command());
        });
    }

    @Override
    public String desc() {
        return "show 展示所有单步操作，仅展示，由 set 设置";
    }
}
