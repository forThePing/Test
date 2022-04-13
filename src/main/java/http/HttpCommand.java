package http;

import init.Command;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpCommand implements Command {
    private String token;
    private HttpClient client;

    public HttpCommand(String token) {
        this.token = token;
    }

    @Override
    public void connect() throws Exception {
        if (token == null) {
            throw new Exception("没有提供有效的登录凭证");
        }
        client = new HttpClient();
    }

    @Override
    public String run(String expression) throws Exception {
        if(token==null) throw new Exception("没有提供有效的登录凭证或连接已关闭");
        Parameter parameter = new Parameter();
        parameter.parse(expression);
        return parameter.response(client, token);
    }

    @Override
    public void disconnect() {
        this.token = null;
    }
}
