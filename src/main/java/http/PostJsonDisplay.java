package http;

import init.Command;
import init.Display;

/**可以考虑添加对执行结果的解析器*/
public class PostJsonDisplay implements Display {
    private Command command;

    public PostJsonDisplay(Command command) {
        this.command = command;
    }

    @Override
    public void run(String str) throws Exception {
        String result = command.run(str);
        System.out.println(result);
    }

    @Override
    public String desc() {
        return "postJson 执行http post 请求 postJson -u http:// -p {\"name\":\"doctor\"}";
    }
}
