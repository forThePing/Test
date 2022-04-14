package http;

import http.method.Method;
import http.method.PostJsonMethod;
import http.parameter.PostJsonParameter;
import init.Command;
import init.Display;
import org.apache.commons.httpclient.HttpMethod;

/**可以考虑添加对执行结果的解析器*/
public class PostJsonDisplay implements Display  {
    private Command<Method> command;

    public PostJsonDisplay(Command<Method> command) {
        this.command = command;
    }

    @Override
    public void run(String str) throws Exception {

        PostJsonParameter parameter = new PostJsonParameter();
        parameter.parse(str);
        PostJsonMethod postJsonMethod = new PostJsonMethod(parameter);
        command.run(postJsonMethod);
        parameter.write(postJsonMethod.result());
    }

    @Override
    public String desc() {
        return "postJson 执行http post 请求 postJson -u http:// -p {\"name\":\"doctor\"} -w json (目前有文本与json的 )";
    }
}
