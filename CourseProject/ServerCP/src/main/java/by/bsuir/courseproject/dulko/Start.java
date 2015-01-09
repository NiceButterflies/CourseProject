/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.dulko;

import by.bsuir.courseproject.dulko.manager.EntityManager;
import by.bsuir.courseproject.dulko.manager.EntityManagerImpl;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евгения
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    private static int curr_port = -1;
    private static Registry registry = null;
    private static EntityManager usersAct = null;
    private static Remote uaStub = null;

    public static void main(String[] args) {

        try {
            if (curr_port != 2600) {
                if (registry != null) {
                    UnicastRemoteObject.unexportObject(registry, true);
                }
                curr_port = 2600;
            }

            registry = LocateRegistry.createRegistry(curr_port);

            if (usersAct == null) {
                usersAct = new EntityManagerImpl();
            }

            if (uaStub == null) {
                uaStub = UnicastRemoteObject.exportObject(usersAct, 0);
            }

            registry.bind("UsersActivities", uaStub);

        } catch (RemoteException | AlreadyBoundException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
