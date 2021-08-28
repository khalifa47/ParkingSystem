import javax.swing.*;
import java.awt.*;

public class AdminPortal extends JFrame{
    private JLabel titleLabel;
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTable jTable1 = new JTable();

    AdminPortal(){
        setVisible(true);
        setSize(900, 600);
        setLocation(300, 90);
        //setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin Portal");

        titleLabel = new JLabel("Login Page");
        titleLabel.setForeground(new java.awt.Color(255, 102, 0));
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN,40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, ""}
                },
                new String [] {
                        "UserID", "Full Name", "E-mail", "Age", "Phone", "Username", "Date Registered", "Selected Plan", ""
                }
        ) {
            final Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            final boolean[] canEdit = new boolean [] {
                    true, true, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(359, Short.MAX_VALUE)
                                .addComponent(titleLabel)
                                .addGap(315, 315, 315))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(titleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 223, Short.MAX_VALUE))
        );

    }
}
