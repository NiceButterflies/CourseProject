/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.client;

import by.bsuir.courseproject.dulko.database.model.Client;
import by.bsuir.courseproject.dulko.logic.ClientLogic;
import by.bsuir.courseproject.dulko.logic.DiscountLogic;
import by.bsuir.courseproject.dulko.logic.PriceListLogic;
import by.bsuir.courseproject.dulko.logic.ProgrammLogic;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Евгения
 */
public class ClientForm extends javax.swing.JFrame {

    public class ImagePanel extends JPanel {

        private BufferedImage image;

        public ImagePanel() throws IOException {
            image = ImageIO.read(new File("C:\\Users\\Евгения\\Documents\\NetBeansProjects\\ClientCP\\Image\\11.jpg"));
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(image, 0, 0, null);
        }
    }

    private String login = null;
    private List<Client> clientList = null;
    private Client client;
    private ClientLogic cl = null;
    private PriceListLogic pll = null;
    private DiscountLogic dl = null;

    /**
     * Creates new form ClientForm
     */
    public ClientForm(String login) {
        initComponents();
        try {
            this.login = login;
            cl = Start.getEntityManager().getClientManager();
            pll = Start.getEntityManager().getPriceListManager();
            dl = Start.getEntityManager().getDiscountManager();
        } catch (RemoteException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        refresh();
        checkRights();
    }

    private void checkRights() {
        if (!login.equals("admin")) {
            jButton1.setVisible(false);
            jButton2.setVisible(false);
            jButton3.setVisible(false);
        }
    }

    private void refresh() {
        if (login.equals("admin")) {
            clientList = cl.getAllClients();
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[clientList.size()][7],
                    new String[]{
                        "#", "Фамилия", "Имя", "Отчество", "Телефон", "Категория", "Скидка"
                    }
            ));
            jTable1.getColumnModel().getColumn(0).setMaxWidth(30);
            if (login.equals("admin")) {
                for (int j = 0; j < clientList.size(); j++) {
                    jTable1.getModel().setValueAt(j + 1, j, 0);
                    jTable1.getModel().setValueAt(clientList.get(j).getSurname(), j, 1);
                    jTable1.getModel().setValueAt(clientList.get(j).getName(), j, 2);
                    jTable1.getModel().setValueAt(clientList.get(j).getLastname(), j, 3);
                    jTable1.getModel().setValueAt(clientList.get(j).getPhoneNumber(), j, 4);
                    jTable1.getModel().setValueAt(dl.getClientCategory(clientList.get(j).getIdDiscount()), j, 5);
                    jTable1.getModel().setValueAt(dl.getNumDiscount(clientList.get(j).getIdDiscount()), j, 6);
                    jTable1.setAutoCreateRowSorter(true);
                }
            }
        } else {
            client = cl.getClientWhereLogin(login);
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[1][7],
                    new String[]{
                        "#", "Фамилия", "Имя", "Отчество", "Телефон", "Категория", "Скидка"
                    }
            ));
            jTable1.getModel().setValueAt(1, 0, 0);
            jTable1.getModel().setValueAt(client.getSurname(), 0, 1);
            jTable1.getModel().setValueAt(client.getName(), 0, 2);
            jTable1.getModel().setValueAt(client.getLastname(), 0, 3);
            jTable1.getModel().setValueAt(client.getPhoneNumber(), 0, 4);
            jTable1.getModel().setValueAt(dl.getClientCategory(client.getIdDiscount()), 0, 5);
            jTable1.getModel().setValueAt(dl.getNumDiscount(client.getIdDiscount()), 0, 6);
            jTable1.setAutoCreateRowSorter(true);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        try {
            jPanel1 = new ImagePanel();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTable1 = new javax.swing.JTable();
            jButton1 = new javax.swing.JButton();
            jButton2 = new javax.swing.JButton();
            jButton3 = new javax.swing.JButton();
            jToggleButton1 = new javax.swing.JToggleButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Клиенты");

        }catch(IOException e) {
            e.printStackTrace();
        }
        jPanel1.setPreferredSize(new java.awt.Dimension(1055, 512));
        jPanel1.setRequestFocusEnabled(false);

        jTable1.setBackground(new java.awt.Color(255, 242, 242));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jTable1.setMaximumSize(new java.awt.Dimension(2147483647, 600));
        jTable1.setPreferredSize(new java.awt.Dimension(2147483647, 600));
        jTable1.setRequestFocusEnabled(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Добавить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Редактировать");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Удалить");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("OK");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(46, 46, 46)
                        .addComponent(jButton2)
                        .addGap(45, 45, 45)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        AddClientForm addClientForm = new AddClientForm(login);
        addClientForm.setVisible(true);
        addClientForm.setTitle("Добавить");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (client != null) {
            dispose();
            AddClientForm addClientForm = new AddClientForm(client, login);
            addClientForm.setVisible(true);
            addClientForm.setTitle("Редактировать");
        } else {
            JOptionPane.showMessageDialog(null, "Выберите запись для редактирования.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (client != null) {
            cl.deleteClient(client);
            refresh();
        } else {
            JOptionPane.showMessageDialog(null, "Выберите запись для удаления.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.rowAtPoint(evt.getPoint());
        int col = jTable1.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
            client = clientList.get(row);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        MainForm mainForm = new MainForm(login);
        mainForm.setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}