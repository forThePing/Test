package ssh;

import init.Command;
import init.Display;
import init.Register;
import ssh.keyword.*;
import ssh.parse.DeletePayLogParse;
import ssh.parse.LogParse;

import java.util.HashMap;
import java.util.Map;

public class SSHRegister implements Register {
    private Command command;
    private Map<String, Display> displayMap;
    private Map<String, Operation> cache;
    private Map<String, LogParse> parseMap;

    public SSHRegister(Command command) {
        this.command = command;
        displayMap = new HashMap<>();
        cache = new HashMap<>();
        parseMap = new HashMap<>();
    }

    @Override
    public void init(){
        initLogParse();
        NumberGenerate numberGenerate = new NumberGenerate();
        HelpDisplay help = new HelpDisplay();
        displayMap.put("help", help);

        EndDisplay end = new EndDisplay(command);
        displayMap.put("end", end);

        SetDisplay set = new SetDisplay(cache, numberGenerate);
        displayMap.put("set", set);

        ShowDisplay show = new ShowDisplay(cache);
        displayMap.put("show", show);

        ResetDisplay reset = new ResetDisplay(cache);
        displayMap.put("reset", reset);

        RemoveDisplay remove = new RemoveDisplay(cache);
        displayMap.put("remove", remove);

        ResetNumberDisplay resetNumber = new ResetNumberDisplay(cache, numberGenerate);
        displayMap.put("resetNumber", resetNumber);

        RunDisplay run = new RunDisplay(command, cache);
        displayMap.put("run", run);

        SetParseDisplay setParse = new SetParseDisplay(parseMap, run);
        displayMap.put("setParse", setParse);

        ShowLogParserDisplay showParse = new ShowLogParserDisplay(parseMap);
        displayMap.put("showParse", showParse);
        selfInit();
        help.addDisplay(help);
        help.addDisplay(end);
        help.addDisplay(set);
        help.addDisplay(show);
        help.addDisplay(reset);
        help.addDisplay(remove);
        help.addDisplay(resetNumber);
        help.addDisplay(run);
        help.addDisplay(setParse);
        help.addDisplay(showParse);
    }

    private void initLogParse() {
        parseMap.put("deletePay", new DeletePayLogParse());
    }

    private void selfInit(){
        try {
            scanner("set cd /***");
            scanner("set cd /**");
            scanner("set ls");
            scanner("set grep -a \"结算\" ***");
            //scanner("setParse deletePay");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void scanner(String str) throws Exception {
        if (str.trim().length()==0) {
            System.out.println("命令不能为空");
            return;
        }
        String[] context = str.split("\\s+");
        Display display = displayMap.get(context[0]);
        if(display==null){
            System.out.println("该命令尚未实现");
            return;
        }
        display.run(str);
    }
}
