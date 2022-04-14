package template;

public abstract class Template<T> {
   public void accept(String expression,T t){
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
            parse(chars, first.length(), first, t);
        }
    }
    protected String value(char[] chars,int offset){
        if (chars.length <= offset) {
            return "";
        }
        return new String(chars, offset, chars.length-1).trim();
    }
    protected abstract void parse(char[] chars ,int offset,String first,T t);
}
