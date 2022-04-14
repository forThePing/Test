package http;

import init.Display;

public class EnvShowDisplay implements Display {

    @Override
    public void run(String str) throws Exception {
        EnvironmentConfig.write();
    }

    @Override
    public String desc() {
        return "envShow 显示所有环境变量";
    }
}
