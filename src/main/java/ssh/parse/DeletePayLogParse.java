package ssh.parse;

public class DeletePayLogParse implements LogParse{
    @Override
    public void parse(String str) {
        if (str.length()==0) {
            return;
        }
        String[] split = str.split("\n");
        for (String value : split) {
            String[] context = value.split("\\|");

            if (context[4].contains("CallbackServiceImpl")) {
                System.out.print("时间："+context[0]);
                System.out.println(" | 租户："+context[2]);
                System.out.println(context[5]);
            }
        }
    }

    @Override
    public String name() {
        return "结算日志解析器";
    }
}
