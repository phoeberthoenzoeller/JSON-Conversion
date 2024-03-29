/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v;
import c.JSON_HTML;


/**
 *
 * @author Charles Gray
 */
public class Preferences extends javax.swing.JFrame
{
//private enum COLORS {RED, BLUE, GREEN, WHITE, BLACK, YELLOW};
private String Colors[] = {"BLACK", "WHITE", "BLUE", "RED", "GREEN", "YELLOW"};  
private JSON_HTML jhtmll;


/**
  * Creates new form Preferences
  */
public Preferences(JSON_HTML jh)
  {
  this.jhtmll=jh;
  initComponents();
  this.jComboBoxLabelColor.removeAllItems();
  this.jComboBoxValueColor.removeAllItems();
  this.jComboBoxProjectName.removeAllItems();
  for(String color: this.Colors)
    {
    this.jComboBoxLabelColor.addItem(color);
    this.jComboBoxValueColor.addItem(color);
    this.jComboBoxProjectName.addItem(color);
    }
  this.setTitle("Preferences");
  this.setVisible(true);
  }

/**
 * This method is called from within the constructor to initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is always
 * regenerated by the Form Editor.
 */
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabelLabelColor = new javax.swing.JLabel();
        jComboBoxLabelColor = new javax.swing.JComboBox<>();
        jButtonSubmit = new javax.swing.JButton();
        jLabelLabelValue = new javax.swing.JLabel();
        jComboBoxValueColor = new javax.swing.JComboBox<>();
        jLabelProjectName = new javax.swing.JLabel();
        jComboBoxProjectName = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelLabelColor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelLabelColor.setText("Label Color");

        jComboBoxLabelColor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBoxLabelColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxLabelColor.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBoxLabelColorActionPerformed(evt);
            }
        });

        jButtonSubmit.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonSubmit.setText("Submit");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jLabelLabelValue.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelLabelValue.setText("Value Color");

        jComboBoxValueColor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBoxValueColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelProjectName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelProjectName.setText("Project Name Color");

        jComboBoxProjectName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBoxProjectName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxProjectName.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBoxProjectNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSubmit)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelLabelColor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxLabelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelLabelValue)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxValueColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelProjectName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jComboBoxProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLabelColor)
                    .addComponent(jComboBoxLabelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLabelValue)
                    .addComponent(jComboBoxValueColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProjectName)
                    .addComponent(jComboBoxProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(jButtonSubmit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxLabelColorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBoxLabelColorActionPerformed
    {//GEN-HEADEREND:event_jComboBoxLabelColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxLabelColorActionPerformed

    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSubmitActionPerformed
    {//GEN-HEADEREND:event_jButtonSubmitActionPerformed
       this.jhtmll.LabelColor=(String)this.jComboBoxLabelColor.getSelectedItem();
       this.jhtmll.ValueColor=(String)this.jComboBoxValueColor.getSelectedItem();
       this.jhtmll.ProjectNameColor=(String)this.jComboBoxProjectName.getSelectedItem();
       this.dispose();
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    private void jComboBoxProjectNameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBoxProjectNameActionPerformed
    {//GEN-HEADEREND:event_jComboBoxProjectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxProjectNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JComboBox<String> jComboBoxLabelColor;
    private javax.swing.JComboBox<String> jComboBoxProjectName;
    private javax.swing.JComboBox<String> jComboBoxValueColor;
    private javax.swing.JLabel jLabelLabelColor;
    private javax.swing.JLabel jLabelLabelValue;
    private javax.swing.JLabel jLabelProjectName;
    // End of variables declaration//GEN-END:variables
    }
