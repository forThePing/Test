package http.parameter;

import http.parse.ResponseParse;
import http.parse.TextResponseParse;
import http.template.HttpPostJsonTemplate;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

public class PostJsonParameter {
    private String url;
    private String parameter;

    private ResponseParse responseParse;

    private HttpPostJsonTemplate httpPostJsonTemplate ;

    public PostJsonParameter() {
        httpPostJsonTemplate = new HttpPostJsonTemplate();
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



    public String getUrl() {
        return url;
    }

    public String getParameter() {
        return parameter;
    }

    public void parse(String expression) throws Exception{
        httpPostJsonTemplate.accept(expression, this);
    }

    public void write(String result) {
        if (responseParse==null) {
            responseParse = new TextResponseParse();
        }
        responseParse.acceptText(result);
    }
    @Override
    public String toString() {
        return "Parameter{" +
                ", url='" + url + '\'' +
                ", parameter='" + parameter + '\'' +
                '}';
    }

}
