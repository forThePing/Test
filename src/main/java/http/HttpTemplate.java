package http;

import template.Template;

public abstract class HttpTemplate<T> extends Template<T> {

    @Override
    protected String value(char[] chars, int offset) {
        String value = super.value(chars, offset);
        return value;
    }
}
