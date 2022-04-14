package http.display;

import http.parameter.EnvSetParameter;
import init.Display;

public class EnvSetDisplay implements Display {

    @Override
    public void run(String expression) throws Exception {
        EnvSetParameter envSetParameter = new EnvSetParameter();
        envSetParameter.parse(expression);
    }

    @Override
    public String desc() {
        return "envSet 设置环境数据，以提供其它命令引用";
    }
}
