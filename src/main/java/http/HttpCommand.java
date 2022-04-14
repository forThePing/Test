package http;

import http.method.Method;
import init.Command;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;

public class HttpCommand implements Command<Method> {
    private String token;
    private HttpClient client;

    public HttpCommand(String token) {
        this.token = token;
    }

    @Override
    public void connect() throws Exception {
        client = new HttpClient();
    }

    @Override
    public String run(Method expression) throws Exception {
        expression.setToken(token);
        return client.executeMethod(expression.getHttpMethod()) + "";
    }

    @Override
    public void disconnect() {

    }
}
