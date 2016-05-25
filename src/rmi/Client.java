package rmi;

import rmi.interfaces.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static rmi.Server.*;

public class Client {
    public static void main(String[] argv) {
        try {

            Registry registry = LocateRegistry.getRegistry(port1);

            GlobalInterface stub = (GlobalInterface) registry.lookup("Global");
            System.out.println(stub.add("Description", "Technology", "Name", "Mail", "Username"));

            System.out.println(stub.list());

            System.out.println(stub.join("Name", "Email", 0));

            System.out.println(stub.interest(0));

            System.out.println(stub.close());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
