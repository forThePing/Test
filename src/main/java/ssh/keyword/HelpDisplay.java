package ssh.keyword;

import init.Display;

import java.util.ArrayList;
import java.util.List;

public class HelpDisplay implements Display {

    List<Display> displays;

    public HelpDisplay() {
        displays = new ArrayList<>();
    }

    public void addDisplay(Display display){
        displays.add(display);
    }
    @Override
    public void run(String str) throws Exception {
        for (Display display : displays) {
            System.out.println(display.desc());
        }
        System.out.println("您现在使用的 ssh 模式 \n 有些命令会导致阻塞，小心使用，若遇到，使用万能大法-重启");
    }

    @Override
    public String desc() {
        return "help 提供帮助信息";
    }
}
