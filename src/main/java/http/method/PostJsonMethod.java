package http.method;

import http.parameter.PostJsonParameter;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

public class PostJsonMethod  implements Method{

    private PostJsonParameter parameter;
    private PostMethod postMethod ;

    private String token;

    public PostJsonMethod(PostJsonParameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public HttpMethod getHttpMethod() {
        if (postMethod == null) {
            postMethod = new PostMethod(parameter.getUrl());
            postMethod.setRequestHeader("Content-Type", "application/json;charset=utf-8");
            postMethod.setRequestHeader("x-access-token", token);
            postMethod.setRequestBody(parameter.getParameter());
        }
        return postMethod;
    }

    @Override
    public String result() throws IOException {
        return postMethod.getResponseBodyAsString();
    }

    @Override
    public int statusCode() {
        return postMethod.getStatusCode();
    }
}
