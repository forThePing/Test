package http.template;

import http.EnvSetParameter;

public class EnvSetTemplate extends HttpEnvTemplate<EnvSetParameter> {
    @Override
    protected void parse(char[] chars, int offset, String first, EnvSetParameter envSetParameter) {
        if(first.equals("n")){
            envSetParameter.setName(value(chars,offset));
            return;
        }
        if(first.equals("v")){
            envSetParameter.setValue(value(chars,offset));
            return;
        }
    }
}
