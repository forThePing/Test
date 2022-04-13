package ssh.keyword;

public class NumberGenerate {

    private Integer index = 0;

    public String get(){
        Integer result = index++;
        return result + "";
    }

    public void reset(){
        index = 0;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
