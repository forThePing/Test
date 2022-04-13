package ssh;

public interface Operation {
    boolean check();
    String error();
    String command();
    void  reset();

    void setOperation(Operation operation);
}
