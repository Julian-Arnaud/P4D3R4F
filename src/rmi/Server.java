package rmi;

import data.Database;
import json.Parser;
import rmi.implement.*;
import rmi.interfaces.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.TimeUnit;

public class Server {
    public static int port1 = 10001 ;

    public static Database d;
    public static Parser p;
    public static boolean closed = false;
    public Server() {
        d = new Database();
        p = new Parser("{}");
        try {
            GlobalInterface skeleton = (GlobalInterface) UnicastRemoteObject.exportObject(new GlobaImpl(), port1);

            Registry r = LocateRegistry.createRegistry(port1);

            r.rebind("Global", skeleton);

            TimeUnit.SECONDS.sleep(15);

            if(closed){
                r.unbind("Global");
                System.exit(0);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
