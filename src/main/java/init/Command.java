package init;

public interface Command<T> {
    void connect() throws Exception;
    String run(T expression) throws Exception;
    void disconnect();
}
