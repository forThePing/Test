package http.parse;

public class ParseFactory {
    public static ResponseParse getResponseParse(String value){
        if("text".equals(value)){
            return new TextResponseParse();
        }
        if("json".equals(value)){
            return   new JsonResponseParse();
        }
        /**给一个默认*/
        return new TextResponseParse();
    }

}
