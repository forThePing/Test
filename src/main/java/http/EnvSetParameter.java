package http;

public class EnvSetParameter {
    private String name;
    private String value;
    EnvSetTemplate envSetTemplate;

    public EnvSetParameter() {
         envSetTemplate = new EnvSetTemplate();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void parse(String expression) throws Exception{
        envSetTemplate.accept(expression, this);
        EnvironmentConfig.putValue(name, value);
    }
}
