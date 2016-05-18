package tcp;

import json.ActionClientSide;
import json.ResponseClientSide;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;

/**
 * @author Julian ARNAUD
 * @date 26/04/2016
 **/
public class ClientBis implements Runnable {

    private String msgSend;
    private String msgRec;
    private String host;
    private int port;
    private Socket s;

    public ClientBis(String msg, String host, int port) throws IOException {
        s = new Socket(host, port);
        this.msgSend = msg;
        this.msgRec = "";
        this.host = host;
        this.port = port;
    }

    public void send(){
        try {

                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                out.writeUTF(msgSend);

                DataInputStream in = new DataInputStream(s.getInputStream());

                msgRec = in.readUTF();
                System.out.println("Recu : " + msgRec);
                out.close();

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
