package ssh.keyword;

import init.Display;
import ssh.Operation;

import java.util.HashMap;
import java.util.Map;

public class ResetNumberDisplay implements Display {

    private NumberGenerate numberGenerate;

    private Map<String, Operation> cache;

    public ResetNumberDisplay(Map<String, Operation> cache, NumberGenerate numberGenerate) {
        this.cache = cache;
        this.numberGenerate = numberGenerate;
    }

    @Override
    public void run(String str) throws Exception {
        Map<String, Operation> cacheTemp = new HashMap<>();
        NumberGenerate generate = new NumberGenerate();
        cache.forEach((key,value)->{
            cacheTemp.put(generate.get(), value);
        });
        cache.clear();
        cache.putAll(cacheTemp);
        numberGenerate.setIndex(cacheTemp.size());
    }

    @Override
    public String desc() {
        return "resetNumber 重置单步命令序列";
    }
}
