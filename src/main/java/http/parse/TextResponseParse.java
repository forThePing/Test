package http.parse;

public class TextResponseParse implements ResponseParse{
    @Override
    public void acceptText(String text) {
        System.out.println(text);
    }
}
