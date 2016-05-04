package tcp;

import data.Database;
import json.ActionClientSide;
import json.Parser;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerTCP {

    public static void main(String[] args){
        Parser p ;
        Database d = new Database();
        ArrayList<String> errors = new ArrayList<>();
        ServerSocket serv = null;
        Socket client = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        //actionClientSide.start();


        //clientTCP.receive();

        try{
            ActionClientSide actionClientSide = new ActionClientSide();
            serv = new ServerSocket(7777);
            ClientTCP clientTCP = new ClientTCP(actionClientSide.getMsg(), "0.0.0.0", 7777);

            clientTCP.send();
            client = serv.accept();
            //Thread t = new Thread((Runnable) client);
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String clAd = client.getInetAddress().toString();
            String line = "";

            while(true){
                actionClientSide = new ActionClientSide();
                actionClientSide.start();
                line = in.readLine();
                System.out.println("Line  :"+line);
                JSONObject data = new JSONObject(line);
                p = new Parser(line);
                String ret="";
                System.out.println(p.getAction());
                switch (p.getAction()){
                    case "ADD" :
                        System.out.println("In the add");
                        d.addIdea(p.get("description"), p.get("technology"), p.get("name"), p.getAuthorUsername(), p.getAuthorMail());
                        ret = p.createResponseAdd(d.getIdea(d.getLastIdeaID()), "OK", errors);
                        break;
                    case "INTEREST" :
                        if (Integer.parseInt( p.getId()) > d.getLastIdeaID()   || Integer.parseInt( p.getId()) < 0){
                            errors.add("Wrong idea id");
                            ret = p.createResponseInterest("KO", errors, d.getInterested(Integer.parseInt( p.getId())));
                            errors = new ArrayList<>();
                        }else {
                            ret = p.createResponseInterest("OK", errors, d.getInterested(Integer.parseInt(p.getId())));
                        }
                        break;
                    case "LIST" :
                        ret = p.createResponseList("OK", d, errors);
                        break;
                    case "JOIN" :
                        if (Integer.parseInt( p.getId()) > d.getLastIdeaID()   || Integer.parseInt( p.getId()) < 0){
                            errors.add("Wrong idea id");
                            ret+= p.createResponseJoin("KO", errors);
                            errors = new ArrayList<>();
                        }else {
                            d.getIdea(Integer.parseInt(p.getId())).join(p.getJoinUsername(), p.getJoinMail());
                            ret = p.createResponseJoin("OK", errors);
                        }
                        break;
                }
                out.write(ret);
                System.out.println("Retour : "+ret);
            }
            /*in.close();
            out.close();
            client.close();
            serv.close();*/
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
