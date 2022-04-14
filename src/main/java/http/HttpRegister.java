package http;

import http.display.EnvSetDisplay;
import http.display.EnvShowDisplay;
import http.display.HelpDisplay;
import http.display.PostJsonDisplay;
import http.method.Method;
import init.Command;
import init.Display;
import init.Register;

import java.util.HashMap;
import java.util.Map;

public class HttpRegister implements Register {

    private Command<Method> command;
    private Map<String, Display> displayMap;

    public HttpRegister(Command<Method> command) {
        this.command = command;
    }

    @Override
    public void init() {
        displayMap = new HashMap<>();
        PostJsonDisplay postJson = new PostJsonDisplay(command);
        displayMap.put("postJson", postJson);

        EnvSetDisplay envSet = new EnvSetDisplay();
        displayMap.put("envSet", envSet);

        EnvShowDisplay envShow = new EnvShowDisplay();
        displayMap.put("envShow", envShow);

        HelpDisplay help = new HelpDisplay();
        displayMap.put("help", help);

        help.addDisplay(postJson);
        help.addDisplay(envSet);
        help.addDisplay(envShow);
    }

    @Override
    public void scanner(String str) throws Exception {
        int i = str.indexOf(32);
        String text = str;
        String expression = str;
        if (i != -1) {
            text = str.substring(0, i);
            expression = str.substring(i);
        }
        Display display = displayMap.get(text);
        if (display==null) {
            System.out.println("该命令不存在");
            return;
        }
        display.run(expression);
    }
}
