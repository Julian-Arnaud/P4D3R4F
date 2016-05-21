package rmi;

import rmi.interfaces.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static rmi.Server.*;

public class Client {
    public static void main(String[] argv) {
        try {

            Registry registry = LocateRegistry.getRegistry(port1);
            Registry registry2 = LocateRegistry.getRegistry(port2);
            Registry registry3 = LocateRegistry.getRegistry(port3);
            Registry registry4 = LocateRegistry.getRegistry(port4);
            Registry registry5 = LocateRegistry.getRegistry(port5);

            AddInterface stub = (AddInterface) registry.lookup("Add");
            System.out.println(stub.add("Description", "Technology", "Name", "Mail", "Username"));

            ListInterface stub2 = (ListInterface) registry2.lookup("List");
            System.out.println(stub2.list());

            JoinInterface stub3 = (JoinInterface) registry3.lookup("Join");
            System.out.println(stub3.join("Name", "Email", 0));

            InterestInterface stub4 = (InterestInterface) registry4.lookup("Interest");
            System.out.println(stub4.interest(0));

            CloseInterface stub5 = (CloseInterface) registry5.lookup("Close");
            System.out.println(stub5.close());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
