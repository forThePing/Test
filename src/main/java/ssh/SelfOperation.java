package ssh;

public class SelfOperation implements Operation {

    private Operation operation;
    private String code;

    public SelfOperation(String code) {
        this.code = code;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean check() {
        if (operation != null) {
            return operation.check() && myCheck();
        }
        return myCheck();
    }
    private boolean myCheck(){
        return code != null && code.trim().length() > 0;
    }

    @Override
    public String error() {
        return null;
    }

    @Override
    public String command() {
        if (operation != null) {
            return operation.command() + "&&" + code;
        }
        return code;
    }

    @Override
    public void reset() {
        operation = null;
    }
}
