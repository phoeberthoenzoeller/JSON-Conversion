/*
 * Copyright Charles Gray
 * All rights reserved
 * Contact author for EULA
 */
package v;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
/**
 *
 * @author chas
 */
public class ViewHTMLFile extends JFrame
{
  
public ViewHTMLFile(String title)
  {
  this.view(title);
  }

void view(String title)
  {
	try
  	{
    String htmlString;

htmlString = 
"<html><head><title>JSON.html</title></head><body><div style=text-align: center;><h2><span style=color: rgb(204, 0, 0);>JSON CONVERTER</span></h2><h3 style=text-align: left; style=margin-left: 0px; style=text-align: left;>Overview: &nbsp;</h3><div body style=text-align: left;>This " +
"program converts JSON formatted text files into more readable HTML.\n" +
"&nbsp;It is tailored specifically to those JSON files produced by a\n" +
"formerly popular knitting site. &nbsp;The program will however operate\n" +
"on all properly formatted JSON files.\n" + 
"A file named json.css is created along with the HTML files.  This .css file must be in the same folder with the html files for the html files to be presented as intended." +
"<br><h3>File Selection:</h3>The file selection interface allows the user to:<br>1) Select a single JSON file.<br>2) Select multiple JSON files.<br>3) Select a folder name that holds JSON files.<br>If\n" +
"a file is selected then those selected files may have any suffix.\n" +
"&nbsp;It is up to the user to ensure that they are valid JSON files\n" +
"from the knitting site. &nbsp;If a folder is selected then the program\n" +
"will convert all files found in that folder with a suffix of \".json\"." +
"  All HTML output files will be written to the same folder as the source JSON files."
  + ".<br><h3>Preferences:</h3>By\n" +
"default all HTML produced is black type on a white background.\n" +
"&nbsp;You may prefer to display categories of text in a different\n" +
"manner. &nbsp;The content of the output is unchanged. &nbsp;Only the\n" +
"presentation is effected.<br><h3>Disclaimer:</h3>This program was\n" +
"thrown together in one evening. &nbsp;It has not had the luxury of the\n" +
"usual software life cycle advantages such as project management, unit\n" +
"testing, beta testing, limited release and review. &nbsp;Nope, I banged\n" +
"out some code and hoped for the best. &nbsp;And so, if this program\n" +
"does not perform as intended please let me know and I'll have another\n" +
"go at it.</div></div></body></html>";
      
      
  //	htmlString="<html><head><title>Simple Page</title></head>";
  //	htmlString +="<body bgcolor=" + '"' + "white" + '"' 
  //        + ", fgcolor=" + '"' + "black" + '"'
  //        + "><hr/><font size=20>This is Html content</font><hr/>";
        
 // 	htmlString+="</body></html>";
  	JEditorPane ed1=new JEditorPane("text/html",htmlString);
    Point loc = getLocation();
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(((screen.width - this.getSize().width) /4),((screen.height - this.getSize().height) / 4));
    this.setTitle(title);
  	this.add(ed1);
  	this.setVisible(true);
  	this.setSize(600,600);
  	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  	}
	catch(Exception e)
  	{
		e.printStackTrace();
		System.out.println("Some problem has occured"+e.getMessage());
  	}
  } // end view
} // end class ViewHTMLFile
  
