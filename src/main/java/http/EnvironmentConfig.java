package http;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentConfig {

    private static Map<String, String> config = new HashMap<>();

    public static void putValue(String name,String value){
        config.put(name, value);
    }

    public static String getValue(String name){
        return config.get(name);
    }
    public static void write(){
        config.forEach((key,value)->{
            System.out.println(key + " : " + value);
        });
    }
}
