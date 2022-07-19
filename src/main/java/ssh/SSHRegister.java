package ssh;

import init.Command;
import init.Display;
import init.Register;
import ssh.config.Context;
import ssh.keyword.*;
import ssh.parse.DeletePayLogParse;
import ssh.parse.ResultParse;

import java.util.HashMap;
import java.util.Map;

public class SSHRegister implements Register {
    private Command command;
    private Context context;
    private Map<String, Display> displayMap;
    private Map<String, ResultParse> parseMap;

    public SSHRegister(Command command) {
       this(command, new Context());
    }

    public SSHRegister(Command command,Context context) {
        this.command = command;
        displayMap = new HashMap<>();
        parseMap = new HashMap<>();
        this.context = context;
    }

    @Override
    public void init(){
        initLogParse();
        NumberGenerate numberGenerate = new NumberGenerate();
        HelpDisplay help = new HelpDisplay();
        displayMap.put("help", help);

        EndDisplay end = new EndDisplay(command);
        displayMap.put("end", end);

        SetDisplay set = new SetDisplay(context, numberGenerate);
        displayMap.put("set", set);

        ShowDisplay show = new ShowDisplay(context);
        displayMap.put("show", show);

        ResetDisplay reset = new ResetDisplay(context);
        displayMap.put("reset", reset);

        RemoveDisplay remove = new RemoveDisplay(context);
        displayMap.put("remove", remove);

        ResetNumberDisplay resetNumber = new ResetNumberDisplay(context);
        displayMap.put("resetNumber", resetNumber);

        RunDisplay run = new RunDisplay(command, context);
        displayMap.put("run", run);

        LineDisplay lineDisplay = new LineDisplay(command);
        displayMap.put("line", lineDisplay);

        SetParseDisplay setParse = new SetParseDisplay(parseMap, run);
        displayMap.put("setParse", setParse);

        ShowLogParserDisplay showParse = new ShowLogParserDisplay(parseMap);
        displayMap.put("showParse", showParse);

        help.addDisplay(help);
        help.addDisplay(end);
        help.addDisplay(set);
        help.addDisplay(show);
        help.addDisplay(reset);
        help.addDisplay(remove);
        help.addDisplay(resetNumber);
        help.addDisplay(run);
        help.addDisplay(lineDisplay);
        help.addDisplay(setParse);
        help.addDisplay(showParse);
    }

    private void initLogParse() {
        parseMap.put("deletePay", new DeletePayLogParse());
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
