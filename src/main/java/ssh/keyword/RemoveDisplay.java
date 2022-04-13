package ssh.keyword;

import init.Display;
import ssh.Operation;

import java.util.Map;

public class RemoveDisplay implements Display {

    private Map<String, Operation> cache;

    public RemoveDisplay(Map<String, Operation> cache) {
        this.cache = cache;
    }

    @Override
    public void run(String str) throws Exception {
        String[] sequence = str.split(" ");
        if (sequence.length <= 1) {
            System.out.println("没有要移除的命令");
            return;
        }
        String[] context = sequence[1].split(",");
        for (String key : context) {
            cache.remove(key);
        }
    }

    @Override
    public String desc() {
        return "remove 移除指定序列的单步命令";
    }
}
