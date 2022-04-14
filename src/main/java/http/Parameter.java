package http;

import http.parse.ParseFactory;
import http.parse.ResponseParse;
import http.parse.TextResponseParse;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

public class Parameter {
    private String type;
    private String url;
    private String parameter;

    private ResponseParse responseParse;
    private PostMethod postMethod;

    private HttpPostJsonTemplate httpPostJsonTemplate ;

    public Parameter() {
        httpPostJsonTemplate = new HttpPostJsonTemplate();
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public void setResponseParse(ResponseParse responseParse) {
        this.responseParse = responseParse;
    }

    public void parse(String expression) throws Exception{
        httpPostJsonTemplate.accept(expression, this);
    }

    public HttpMethod httpMethod(){
         postMethod = new PostMethod(url);
        postMethod.setRequestHeader("Content-Type", "application/json;charset=utf-8");
        if (parameter!=null) {
            postMethod.setRequestBody(parameter);
        }
        return postMethod;
    }
    public void write() throws IOException {
        if (responseParse==null) {
            responseParse = new TextResponseParse();
        }
        responseParse.acceptText(postMethod.getResponseBodyAsString());
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", parameter='" + parameter + '\'' +
                '}';
    }

}
