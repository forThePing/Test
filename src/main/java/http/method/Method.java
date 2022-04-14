package http.method;

import org.apache.commons.httpclient.HttpMethod;

import java.io.IOException;

public interface Method {
    void setToken(String token);
    HttpMethod getHttpMethod();
    String result() throws IOException;
    int statusCode();
}
