package http;

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
        System.out.println("您现在使用的 http 模式");
    }

    @Override
    public String desc() {
        return "help 提供帮助信息";
    }
}
