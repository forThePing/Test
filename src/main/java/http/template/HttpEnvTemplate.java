package http.template;

import http.EnvironmentConfig;
import template.Template;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class HttpEnvTemplate<T> extends Template<T> {

    private static Pattern pattern = Pattern.compile("[$](.*?)[$]");
    @Override
    protected String value(char[] chars, int offset) {
        String value = super.value(chars, offset);
        Matcher matcher = pattern.matcher(value);
        Map<String, String> cache = new HashMap<>();
        while(matcher.find()) {
            cache.put("\\$"+matcher.group(1)+"\\$", EnvironmentConfig.getValue(matcher.group(1)));
        }
        value = value.trim();
        for (Map.Entry<String, String> entry : cache.entrySet()) {
            value = value.replaceAll(entry.getKey(), entry.getValue());
        }
        return value;
    }

}
