package http;

import template.Template;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class HttpTemplate<T> extends Template<T> {

    private static Pattern pattern = Pattern.compile("^\\$.*\\$$");
    @Override
    protected String value(char[] chars, int offset) {
        String value = super.value(chars, offset);
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            return value;
        }
        value = value.trim();
        value = value.replace("$", "");
        return EnvironmentConfig.getValue(value);
    }
}
