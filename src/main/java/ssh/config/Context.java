package ssh.config;

import ssh.Operation;
import ssh.keyword.NumberGenerate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Context {

    private NumberGenerate numberGenerate;

    private Map<String, Operation> cache;

    public Context( ) {
        this.cache = new HashMap<>();
        numberGenerate = new NumberGenerate();
    }

    public void putOperation(String key, Operation operation){
        cache.put(key, operation);
    }

    public void resetNumber(){
        Map<String, Operation> cacheTemp = new HashMap<>();
        NumberGenerate generate = new NumberGenerate();
        forEachOperation((key, value)->{
            cacheTemp.put(generate.get(), value);
        });
        cache.clear();
        cache.putAll(cacheTemp);
        numberGenerate.setIndex(cacheTemp.size());
    }

    public Operation getOperation(String key){
       return cache.get(key);
    }

    public void removeOperation(String key){
        cache.remove(key);
    }

    public void forEachOperation(BiConsumer<String,Operation> consumer){
        cache.forEach(consumer::accept);
    }
}
