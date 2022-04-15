package ssh.keyword;

import init.Display;
import ssh.parse.ResultParse;

import java.util.Map;

public class ShowLogParserDisplay  implements Display {
    private Map<String, ResultParse> parseMap;

    public ShowLogParserDisplay(Map<String, ResultParse> parseMap) {
        this.parseMap = parseMap;
    }

    @Override
    public void run(String str) throws Exception {
        parseMap.forEach((key,value)->{
            System.out.println(key + ":" + value.name());
        });
    }

    @Override
    public String desc() {
        return "showParse 显示可用的日志解析器，内置";
    }
}
