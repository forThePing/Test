package http;

import init.Command;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;

public class HttpCommand implements Command<HttpMethod> {
    private String token;
    private HttpClient client;

    public HttpCommand(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public void connect() throws Exception {
        if (token == null) {
            throw new Exception("没有提供有效的登录凭证");
        }
        client = new HttpClient();
    }

    @Override
    public String run(HttpMethod expression) throws Exception {
        if(token==null) throw new Exception("没有提供有效的登录凭证或连接已关闭");
        expression.setRequestHeader("x-access-token", token);
        return client.executeMethod(expression) + "";
    }

    @Override
    public void disconnect() {
        this.token = null;
    }
}
