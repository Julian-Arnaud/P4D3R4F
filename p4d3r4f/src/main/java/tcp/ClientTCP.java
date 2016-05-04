package tcp;

import java.io.*;
import java.net.Socket;

/**
 * @author Julian ARNAUD
 * @date 26/04/2016
 **/
public class ClientTCP implements Runnable {

    private String msgSend;
    private String msgRec;
    private String host;
    private int port;

    public ClientTCP(String msg, String host, int port){
        this.msgSend = msg;
        this.msgRec = "";
        this.host = host;
        this.port = port;
    }

    public void send(){
        try {
            Socket s = new Socket(host, port);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            out.write(msgSend);

            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receive(){
        try{
            Socket s = new Socket(host, port);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            msgRec = in.toString();

            in.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMsgRec() {
        return msgRec;
    }

    public String getMsgSend() {
        return msgSend;
    }

    @Override
    public void run() {
        send();
    }
}
