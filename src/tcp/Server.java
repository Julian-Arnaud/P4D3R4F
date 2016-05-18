package tcp;

/**
 * Created by guillaume on 04/05/16.
 */
import data.Database;
import json.Parser;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server
{
    private static String        _message = "Hello I'm your server.";
    private static int           _port;
    private static ServerSocket  _socket;

    public static void main(String[] args){
        Database d = new Database();
        ArrayList<String> errors = new ArrayList<>();
        try
        {
            _port   = (args.length == 1) ? Integer.parseInt(args[0]) : 8050;
            _socket = new ServerSocket(_port);

            System.out.println("TCP server is running on " + _port + "...");

            while (true)
            {
                // Accept new TCP client
                Socket client       = _socket.accept();
                InputStream input = client.getInputStream();

                String response = new DataInputStream(input).readUTF();
                System.out.println(response);
                // Open output stream
                DataOutputStream output = new DataOutputStream(client.getOutputStream());
                System.out.println("New client, address " + client.getInetAddress() + " on " + client.getPort() + ".");
                try {
                    JSONObject data = new JSONObject(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Parser p = new Parser(response);
                System.out.println(p.getAction());

                String ret="";
                switch (p.getAction()){
                    case "ADD" :
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

                errors = new ArrayList<>();
                // Write the message and close the connection
                System.out.println("Ret : "+ret);
                output.writeUTF(ret);
                output.write('\0');
                output.flush();
                client.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                _socket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
