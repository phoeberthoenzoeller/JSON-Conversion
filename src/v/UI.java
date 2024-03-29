/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v;
import c.JSON_HTML;
import v.SelectJSONFiles;
import v.Preferences;
import javax.swing.JOptionPane;


/**
 *
 * @author Charles Gray
 */
public class UI extends javax.swing.JFrame
{
JSON_HTML jhtmll;
SelectJSONFiles sjf;



/**
  * Creates new form UI
  */
public UI()
  {
  initComponents();
  this.setVisible(true);
  this.setTitle("JSON Conversion");
  this.jhtmll = new JSON_HTML();   
  this.sjf = new SelectJSONFiles();
  }


private void convert()
  {
  int filesConverted = this.jhtmll.convert();
  JOptionPane.showMessageDialog(null, filesConverted + " files successfully converted.", "NOTICE", JOptionPane.INFORMATION_MESSAGE);
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

        jButtonSelectJSONFiles = new javax.swing.JButton();
        jButtonConvert = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemSelectFiles = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemPreferences = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemInstructions = new javax.swing.JMenuItem();
        jMenuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonSelectJSONFiles.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonSelectJSONFiles.setText("Select JSON Files");
        jButtonSelectJSONFiles.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonSelectJSONFilesActionPerformed(evt);
            }
        });

        jButtonConvert.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonConvert.setText("Convert");
        jButtonConvert.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonConvertActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMenuItemSelectFiles.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItemSelectFiles.setText("Select Input File(s)");
        jMenuItemSelectFiles.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItemSelectFilesActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSelectFiles);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMenuItemPreferences.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItemPreferences.setText("Preferences");
        jMenuItemPreferences.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItemPreferencesActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemPreferences);

        jMenuBar1.add(jMenu2);

        jMenuHelp.setText("Help");
        jMenuHelp.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMenuItemInstructions.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItemInstructions.setText("Instructions");
        jMenuItemInstructions.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItemInstructionsActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemInstructions);

        jMenuItemAbout.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItemAbout.setText("About");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemAbout);

        jMenuBar1.add(jMenuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButtonSelectJSONFiles)
                .addGap(29, 29, 29)
                .addComponent(jButtonConvert)
                .addGap(0, 41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSelectJSONFiles)
                    .addComponent(jButtonConvert))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemPreferencesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItemPreferencesActionPerformed
    {//GEN-HEADEREND:event_jMenuItemPreferencesActionPerformed
        new Preferences(this.jhtmll);
    }//GEN-LAST:event_jMenuItemPreferencesActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItemAboutActionPerformed
    {//GEN-HEADEREND:event_jMenuItemAboutActionPerformed
    new Help_AboutBox();
    }//GEN-LAST:event_jMenuItemAboutActionPerformed

    private void jMenuItemInstructionsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItemInstructionsActionPerformed
    {//GEN-HEADEREND:event_jMenuItemInstructionsActionPerformed
        new ViewHTMLFile("JSON Converter Help");
    }//GEN-LAST:event_jMenuItemInstructionsActionPerformed

    private void jMenuItemSelectFilesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItemSelectFilesActionPerformed
    {//GEN-HEADEREND:event_jMenuItemSelectFilesActionPerformed
       this.jhtmll.filesJSON = this.sjf.selectJsonFiles();  // User chooses file(s) via browser, returns a File object 
    }//GEN-LAST:event_jMenuItemSelectFilesActionPerformed

    private void jButtonSelectJSONFilesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSelectJSONFilesActionPerformed
    {//GEN-HEADEREND:event_jButtonSelectJSONFilesActionPerformed
      this.jhtmll.filesJSON = this.sjf.selectJsonFiles();  // User chooses file(s) via browser, returns a File object 
    }//GEN-LAST:event_jButtonSelectJSONFilesActionPerformed

    private void jButtonConvertActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonConvertActionPerformed
    {//GEN-HEADEREND:event_jButtonConvertActionPerformed
      this.convert(); 
    }//GEN-LAST:event_jButtonConvertActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
        {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
            {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
                {
                if ("Nimbus".equals(info.getName()))
                    {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                    }
                }
            } catch (ClassNotFoundException ex)
            {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex)
            {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex)
            {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex)
            {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
            {
            public void run()
                {
                new UI().setVisible(true);
                }
            });
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConvert;
    private javax.swing.JButton jButtonSelectJSONFiles;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemInstructions;
    private javax.swing.JMenuItem jMenuItemPreferences;
    private javax.swing.JMenuItem jMenuItemSelectFiles;
    // End of variables declaration//GEN-END:variables
    }
