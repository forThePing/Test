package ssh;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class JSchUtil {
    private JSch jSch ;

    public JSchUtil(Login login) {

    }
    public void init() throws JSchException {
        Session session = jSch.getSession("everjiankang", "10.100.1.229", 22);
        session.setPassword("everjiankang");
        session.setConfig("StrictHostKeyChecking", "no");
    }
}
