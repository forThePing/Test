package ssh;

import com.jcraft.jsch.*;
import init.Command;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class SshCommand implements Command<String> {

    private String host;
    private int port ;
    private String userName;
    private String passWord;

    private Session session ;

    public SshCommand(String host, int port, String userName, String passWord) {
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.passWord = passWord;
    }

    @Override
    public void connect() throws Exception {
        JSch jSch = new JSch();
        session = jSch.getSession(userName, host, port);
        session.setPassword(passWord);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();

    }

    @Override
    public String run(String expression) throws Exception {
        if (session ==null && !session.isConnected()){
            throw new Exception("尚未建立ssh连接");
        }
        Channel channel = session.openChannel("exec");

        ((ChannelExec) channel).setCommand(expression);
        channel.setInputStream(null);
        ((ChannelExec) channel).setErrStream(System.err);
        channel.connect();
        InputStream in = channel.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));

        String buf = null;
        StringBuffer buffer = new StringBuffer();
        while ((buf = reader.readLine()) != null) {
            buffer.append(buf);
            buffer.append("\n");
        }
        channel.disconnect();
       return buffer.toString();
    }

    @Override
    public void disconnect() {
        if (session !=null && session.isConnected()){
            session.disconnect();
        }
    }
}
