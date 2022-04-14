package http;

import http.parse.ParseFactory;

public class HttpPostJsonTemplate extends HttpTemplate<PostJsonParameter> {

    @Override
    protected void parse(char[] chars,int offset,String first, PostJsonParameter parameter) {
        if(first.equals("t")){
            parameter.setType(value(chars,offset));
            return;
        }
        if(first.equals("p")){
            parameter.setParameter(value(chars,offset));
            return;
        }
        if(first.equals("u")){
            parameter.setUrl(value(chars,offset));
            return;
        }
        if(first.equals("w")){
            parameter.setResponseParse(ParseFactory.getResponseParse(value(chars,offset)));
            return;
        }
    }
}
