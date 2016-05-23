package rmi;

import data.Database;
import json.Parser;
import rmi.implement.*;
import rmi.interfaces.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class Server {
    public static int port1 = 10000 ;

    public static Database d;
    public static Parser p;
    public Server() {
        d = new Database();
        p = new Parser("{}");
        try {
            GlobalInterface skeleton = (GlobalInterface) UnicastRemoteObject.exportObject(new GlobaImpl(), port1);

            Registry registry = LocateRegistry.createRegistry(port1);

            registry.rebind("Global", skeleton);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
