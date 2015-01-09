/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.client;

import by.bsuir.courseproject.dulko.manager.EntityManager;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Евгения
 */
public class Start {

    private static EntityManager entityManager = null;

    private Start() {
    }

    public synchronized static EntityManager getEntityManager() {
        if (entityManager == null) {
            try {
                Registry registry = LocateRegistry.getRegistry("localhost",
                        2600);
                entityManager = (EntityManager) registry
                        .lookup("UsersActivities");
                return entityManager;
            } catch (RemoteException | NotBoundException ex) {
                JOptionPane.showMessageDialog(null, "Сервер не отвечает. Попробуйте позже.");
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null,
                        ex);
            }
        }
        return entityManager;
    }
}
