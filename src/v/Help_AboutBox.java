package v;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Help_AboutBox
  extends JDialog implements ActionListener
{
  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();
  JPanel insetsPanel1 = new JPanel();
  JPanel insetsPanel2 = new JPanel();
  JPanel insetsPanel3 = new JPanel();
  JButton button1 = new JButton();
  JLabel imageLabel = new JLabel();
  JLabel labelproduct = new JLabel();
  JLabel labelversion = new JLabel();
  JLabel labelcopyright = new JLabel();
  JLabel labelauthor = new JLabel();
  JLabel labelcomments1 = new JLabel();
  JLabel labelcomments2 = new JLabel();
  ImageIcon image1 = new ImageIcon();
  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout2 = new BorderLayout();
  FlowLayout flowLayout1 = new FlowLayout();
  GridLayout gridLayout1 = new GridLayout();
  String product = "JSON converter.";
  String version = "Version 1.0";
  String copyright = "Copyright (c) 2019";
  String author = "Charles Gray";
  String comments1 = "All rights reserved.";
  String comments2 = "For my sweet wife.";

  public Help_AboutBox(Frame parent)
  {
    super(parent);
    try
    {
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      jbInit();
      this.setSize(400, 200);
      this.setVisible(true);
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
    }
  }

  public Help_AboutBox()
  {
    this(null);
  }

  /**
   * Component initialization.
   *
   * @throws java.lang.Exception
   */
  private void jbInit() throws Exception
  {
    image1 = new ImageIcon(v.Help_AboutBox.class.getResource("about.png"));
    imageLabel.setIcon(image1);
    setTitle("About JSON Converter");
    panel1.setLayout(borderLayout1);
    panel2.setLayout(borderLayout2);
    insetsPanel1.setLayout(flowLayout1);
    insetsPanel2.setLayout(flowLayout1);
    insetsPanel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    gridLayout1.setRows(4);
    gridLayout1.setColumns(1);
    labelproduct.setText(product);
    labelversion.setText(version);
    labelcopyright.setText(copyright);
    labelcomments1.setText(comments1);
    labelcomments2.setText(comments2);
    labelauthor.setText(author);
    insetsPanel3.setLayout(gridLayout1);
    insetsPanel3.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 10));
    button1.setText("OK");
    button1.addActionListener(this);
    insetsPanel2.add(imageLabel, null);
    panel2.add(insetsPanel2, BorderLayout.WEST);
    getContentPane().add(panel1, null);
    insetsPanel3.add(labelproduct, null);
    insetsPanel3.add(labelversion, null);
    insetsPanel3.add(labelcopyright, null);
    insetsPanel3.add(labelauthor, null);
    insetsPanel3.add(labelcomments1, null);
    insetsPanel3.add(labelcomments2, null);
    panel2.add(insetsPanel3, BorderLayout.CENTER);
    insetsPanel1.add(button1, null);
    panel1.add(insetsPanel1, BorderLayout.SOUTH);
    panel1.add(panel2, BorderLayout.NORTH);
    setResizable(true);
  }

  /**
   * Close the dialog on a button event.
   *
   * @param actionEvent ActionEvent
   */
  public void actionPerformed(ActionEvent actionEvent)
  {
    if (actionEvent.getSource() == button1)
    {
      dispose();
    }
  }
}