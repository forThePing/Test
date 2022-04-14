package http;

import http.parse.JsonResponseParse;
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

    public void parse(String expression) throws Exception{
        /**run -t type -p [] -u http://*/
        String[] context = expression.split("\\s+-");
        for (String str : context) {
            if(str.length()==0){
                continue;
            }
            char[] chars = str.toCharArray();
            if (chars.length<=1) {
                continue;
            }
            String first = "";
            for (char c : chars) {
                if (c==32) {
                    break;
                }
                first += c;
            }

            if(first.equals("t")){
                type = value(chars);
                continue;
            }
            if(first.equals("p")){
                parameter = value(chars);
                continue;
            }
            if(first.equals("u")){
                url = value(chars);
                continue;
            }
            if(first.equals("w")){
                responseParse = ParseFactory.getResponseParse(value(chars));
                continue;
            }
        }
    }
    private String value(char[] chars){
        if (chars.length<=1) return "";
        return new String(chars, 1, chars.length-1).trim();
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
