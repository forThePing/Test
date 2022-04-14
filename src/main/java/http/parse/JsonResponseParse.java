package http.parse;

import com.alibaba.fastjson.JSONObject;

public class JsonResponseParse implements ResponseParse{
    @Override
    public void acceptText(String text) {
        JSONObject parse = JSONObject.parseObject(text);
        parse.forEach((key,value)->{
            System.out.println(key + " : " + value);
        });
    }
}
