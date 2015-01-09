/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.courseproject.client;

import by.bsuir.courseproject.dulko.database.model.Query;
import by.bsuir.courseproject.dulko.database.model.Workout;
import by.bsuir.courseproject.dulko.logic.AddQueryLogic;
import by.bsuir.courseproject.dulko.logic.ClientLogic;
import by.bsuir.courseproject.dulko.logic.InstructorLogic;
import by.bsuir.courseproject.dulko.logic.PriceListLogic;
import by.bsuir.courseproject.dulko.logic.ProgrammLogic;
import by.bsuir.courseproject.dulko.logic.ScheduleLogic;
import by.bsuir.courseproject.dulko.logic.WorkoutLogic;
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
public class QueryForm extends javax.swing.JFrame {

    private String login = null;
    private List<Query> queryList;
    private List<Query> queryList1;
    private Query query;
    private Query query1;
    private Workout workout = null;
    private AddQueryLogic ql = null;
    private ClientLogic cl = null;
    private WorkoutLogic wl = null;
    private InstructorLogic il = null;
    private ProgrammLogic pl = null;
    private PriceListLogic pll = null;
    private ScheduleLogic sl = null;

    /**
     * Creates new form QueryForm
     */
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

    public QueryForm(String login) {
        initComponents();
        try {
            this.login = login;
            ql = Start.getEntityManager().getAddQueryManager();
            cl = Start.getEntityManager().getClientManager();
            wl = Start.getEntityManager().getWorkoutManager();
            il = Start.getEntityManager().getInstructorManager();
            pl = Start.getEntityManager().getProgrammManager();
            pll = Start.getEntityManager().getPriceListManager();
            sl = Start.getEntityManager().getScheduleManager();

        } catch (RemoteException ex) {
            Logger.getLogger(WorkoutForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshTab1();
        workout = new Workout();
        if (queryList.isEmpty()) {
            if (login.equals("admin")) {
                JOptionPane.showMessageDialog(null, "Нет новых заявок!");
            } else {
                JOptionPane.showMessageDialog(null, "У вас нет неодобренных заявок!");
            }
            this.dispose();
        }
    }

    private void refreshTab1() {
        if (login.equals("admin")) {
            queryList = ql.getAllQuerys("На обработке");
        } else {
            queryList = ql.getQuerysByClient(cl.getClientWhereLogin(login).getId());
            jButton3.setVisible(false);
            jButton1.setText("Удалить");
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[queryList.size()][8],
                new String[]{
                    "#", "Фамилия", "Имя", "Отчество", "Программа", "Тип занятий", "Кол-во занятий в мес.",}
        ));
        jTable1.getColumnModel().getColumn(0).setMaxWidth(30);
        for (int j = 0; j < queryList.size(); j++) {
            jTable1.getModel().setValueAt(j + 1, j, 0);
            jTable1.getModel().setValueAt(cl.getSurname(queryList.get(j).getIdClient()), j, 1);
            jTable1.getModel().setValueAt(cl.getName(queryList.get(j).getIdClient()), j, 2);
            jTable1.getModel().setValueAt(cl.getLastname(queryList.get(j).getIdClient()), j, 3);
            jTable1.getModel().setValueAt(pl.getNameProgramm(queryList.get(j).getIdProgramm()), j, 4);
            jTable1.getModel().setValueAt(pll.getPriceList(queryList.get(j).getIdSubscription()).getTypeSubscription(), j, 5);
            jTable1.getModel().setValueAt(pll.getPriceList(queryList.get(j).getIdSubscription()).getDurationSubscription(), j, 6);
            jTable1.setAutoCreateRowSorter(true);
        }

    }

    private void refreshTab2() {
        if (login.equals("admin")) {
            queryList1 = ql.getQuerysByClientProgrammSubscription(this.query.getIdClient(), this.query.getIdProgramm(), this.query.getIdSubscription(), "На обработке");
        } else {
            queryList1 = ql.getQuerysByClientProgrammSubscription(this.query.getIdClient(), this.query.getIdProgramm(), this.query.getIdSubscription());

        }
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[queryList1.size()][5],
                new String[]{
                    "#", "День недели", "Время", "Инструктор", "Статус"
                }
        ));
        jTable2.getColumnModel().getColumn(0).setMaxWidth(30);
        for (int j = 0; j < queryList1.size(); j++) {
            jTable2.getModel().setValueAt(j + 1, j, 0);
            switch (sl.getWeekday(queryList1.get(j).getIdSchedule())) {
            case "1": jTable2.getModel().setValueAt("пн", j, 1); break;
                case "2": jTable2.getModel().setValueAt("вт", j, 1); break;
                    case "3": jTable2.getModel().setValueAt("ср", j, 1); break;
                        case "4": jTable2.getModel().setValueAt("чт", j, 1); break;
                            case "5": jTable2.getModel().setValueAt("пт", j, 1); break;
                                case "6": jTable2.getModel().setValueAt("сб", j, 1); break;
                            }
            jTable2.getModel().setValueAt(sl.getTime(queryList1.get(j).getIdSchedule()), j, 2);
            jTable2.getModel().setValueAt(il.getSurname(sl.getIdInstructor(queryList1.get(j).getIdSchedule())), j, 3);
            jTable2.getModel().setValueAt(queryList1.get(j).getStatus(), j, 4);
            jTable2.setAutoCreateRowSorter(true);
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
            jButton2 = new javax.swing.JButton();
            jScrollPane2 = new javax.swing.JScrollPane();
            jTable2 = new javax.swing.JTable();
            jButton1 = new javax.swing.JButton();
            jButton3 = new javax.swing.JButton();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Заявки на абонементы");

        }catch(IOException e) {
            e.printStackTrace();
        }
        jPanel1.setPreferredSize(new java.awt.Dimension(1055, 514));

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
        jTable1.setName(""); // NOI18N
        jTable1.setPreferredSize(new java.awt.Dimension(375, 600));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Ок");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setBackground(new java.awt.Color(255, 242, 242));
        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTable2.setPreferredSize(new java.awt.Dimension(300, 600));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Одобрить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Отклонить");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Выберите, заявку на какой абонемент вы хотите просмотреть");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Выберите возможное время");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 337, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.rowAtPoint(evt.getPoint());
        int col = jTable1.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
            this.query = queryList.get(row);
            refreshTab2();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        MainForm mainForm = new MainForm(login);
        mainForm.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int row = jTable2.rowAtPoint(evt.getPoint());
        int col = jTable2.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
            this.query1 = queryList1.get(row);
            System.out.println(query1);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (query != null) {
            if (query1 != null) {
                if (login.equals("admin")) {
                    int n = (this.query1.getIdClient());
                    this.workout.setIdClient(n);
                    this.workout.setIdProgramm(this.query1.getIdProgramm());
                    this.workout.setIdSchedule(this.query1.getIdSchedule());
                    this.workout.setIdSubscription(this.query1.getIdSubscription());
                    wl.saveWorkout(workout);
                    ql.deleteQuery(query1);
                    JOptionPane.showMessageDialog(null, "Заявка одобрена!");

                } else {
                    ql.deleteQuery(query1);
                }
                refreshTab1();
                refreshTab2();
            } else {
                JOptionPane.showMessageDialog(null, "Выберите время, которое хотите удалить!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Выберите заявку!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (query != null) {
            if (query1 != null) {
                this.query1.setStatus("Отклонено");
                ql.saveQuery(query1);
                JOptionPane.showMessageDialog(null, "Заяка отклонена!");
                refreshTab1();
                refreshTab2();
            } else {
                JOptionPane.showMessageDialog(null, "Выберите время!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Выберите заявку!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
