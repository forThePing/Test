package http;

import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class Parameter {
    private String type;
    private String url;
    private String parameter;

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getParameter() {
        return parameter;
    }

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
            char first = chars[0];
            if(first=='t'){
                type = value(chars);
                continue;
            }
            if(first=='p'){
                parameter = value(chars);
                continue;
            }
            if(first=='u'){
                url = value(chars);
                continue;
            }
        }
    }
    private String value(char[] chars){
        if (chars.length<=1) return "";
        return new String(chars, 1, chars.length-1).trim();
    }

    public HttpMethod httpMethod(){
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestHeader("Content-Type", "application/json;charset=utf-8");
        if (parameter!=null) {
            postMethod.setRequestBody(parameter);
        }
        return postMethod;
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
