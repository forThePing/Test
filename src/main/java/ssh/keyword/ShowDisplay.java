package ssh.keyword;

import init.Display;
import ssh.config.Context;

public class ShowDisplay implements Display {

    private Context context;

    public ShowDisplay(Context context) {
        this.context = context;
    }

    @Override
    public void run(String str) {
        context.forEachOperation((key, operation)->{
            System.out.println(key + "：" + operation.command());
        });
    }

    @Override
    public String desc() {
        return "show 展示所有单步操作，仅展示，由 set 设置";
    }
}
