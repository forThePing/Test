package ssh.keyword;

import init.Display;
import ssh.parse.ResultParse;

import java.util.Map;

public class SetParseDisplay implements Display {

    private Map<String, ResultParse> parseMap;
    private RunDisplay runDisplay;

    public SetParseDisplay(Map<String, ResultParse> parseMap, RunDisplay runDisplay) {
        this.parseMap = parseMap;
        this.runDisplay = runDisplay;
    }

    @Override
    public void run(String str) throws Exception {
        String[] context = str.split("\\s+");
        if(context.length<=1) return;
        ResultParse logParse = parseMap.get(context[1]);
        /**如果不存在表示输出在控制台*/
        runDisplay.setLogParse(logParse);

    }

    @Override
    public String desc() {
        return "setParse 设置输出内容的解析器，若不存在则结果输出在控制台";
    }
}
