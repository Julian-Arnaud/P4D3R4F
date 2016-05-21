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
    public static int port2 = port1+1000;
    public static int port3 = port2+1000;
    public static int port4 = port3+1000;
    public static int port5 = port4+1000;

    public static Database d;
    public static Parser p;
    public Server() {
        d = new Database();
        p = new Parser("{}");
        try {
            AddInterface skeleton = (AddInterface) UnicastRemoteObject.exportObject(new AddImpl(), port1);
            ListInterface skeleton2 = (ListInterface) UnicastRemoteObject.exportObject(new ListImpl(), port2);
            JoinInterface skeleton3 = (JoinInterface) UnicastRemoteObject.exportObject(new JoinImpl(), port3);
            InterestInterface skeleton4 = (InterestInterface) UnicastRemoteObject.exportObject(new InterestImpl(), port4);
            CloseInterface skeleton5 = (CloseInterface) UnicastRemoteObject.exportObject(new CloseImpl(), port5);

            Registry registry = LocateRegistry.createRegistry(port1);
            Registry registry2 = LocateRegistry.createRegistry(port2);
            Registry registry3 = LocateRegistry.createRegistry(port3);
            Registry registry4 = LocateRegistry.createRegistry(port4);
            Registry registry5 = LocateRegistry.createRegistry(port5);

            registry.rebind("Add", skeleton);
            registry2.rebind("List", skeleton2);
            registry3.rebind("Join", skeleton3);
            registry4.rebind("Interest", skeleton4);
            registry5.rebind("Close", skeleton5);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
