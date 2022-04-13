package init;

public interface Command {
    void connect() throws Exception;
    String run(String expression) throws Exception;
    void disconnect();
}
