package v;
/*      Class: Logfile
	Author: Charles Gray
        Creation Date: 11/14/00
        Creation and maintenance of program logfile.
        Invoked by: Bullutil, Tcp, Init
        Invokes: None
        Description: This is a helper class.  It is not instantiated.
        Methods:  // print to log if threshold >= debuglevel.
        static boolean openLogfile
        Logging thresholds set in <thresh>:
          1) Info
          2) Warning and info
          3) Error, warning, and info.
          4) No logging. (valid <debuglevel> cannot meet or exceed this value.
        If passed argument <int debuglevel> meets or exceeds <thresh> then write the log record.
          (String logname, String progname, String version, int thresh)
        public static void print(String s, int debuglevel)
        public static void println(String s, int debuglevel)
        public static void printlnnc(String s, int debuglevel)
        public static void tprint(String s, int debuglevel)
        public static void tprintln(String s, int debuglevel)
        public static boolean closeLogfile()
        public static String timeStamp()      // returns time string.
        public static void cat2start(String cat2)  //   tprintln("Start",2);
        public static void cat2end()  //  tprintln("End",2);

*/

import java.io.*;
import java.util.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import javax.swing.JOptionPane;


public class Logfile
{
public PrintWriter fplog;  // = new PrintWriter(fpl)
int threshold;   // debug threshold level.
public boolean logfileStatus;
String progname1;


  /**
   *
   * @param logname
   * @param progname
   * @param version
   * @param thresh
   */
  public Logfile(String logname, String progname, String version, int thresh)
  {  
  this.logfileStatus=false;
  this.logfileStatus = openLogfile(logname, progname, version, thresh);
  }

  
  
/**
   *
   * @param logname
   * @param progname
   * @param version
   */
  public Logfile(String logname, String progname, String version)
  {  
  this(logname, progname, version, 1);
  }  
    
  
  
/**
   *
   * @param logname
   * @param progname
   */
  public Logfile(String logname, String progname)
  {  
  this(logname, progname, "",1);
  }  
  
  /**
   *
   * @param logname
   * @param progname
   * @param version
   * @param thresh
   * @return
   */
  public final boolean openLogfile(String logname, String progname, String version, int thresh)
  {
  if(!checkThresh(thresh)) return false;
  progname1 = progname;
  try
    {
    fplog = new PrintWriter(new FileWriter(logname));
    fplog.println("Begin " + progname + " at " + new Date().toString());
    fplog.println(progname + " Version " + version + ".");
    fplog.println("debuglevel = " + thresh + ".");
    String ids[] = TimeZone.getAvailableIDs(-4 * 60 * 60 * 1000);
    SimpleTimeZone edt = new SimpleTimeZone(-4 * 60 * 60 * 1000, ids[0]);
    Calendar cal = new GregorianCalendar(edt);
    Date currentTime = new Date();
    cal.setTime(currentTime);
    }
  catch (IOException e)
    {
    System.err.println("Warning 0: Cannot open logfile " + logname + " for write.");
    return false;
    }
  threshold = thresh;
  return true;
  }



public void print(String s, int debuglevel)
  {
  if (debuglevel >= threshold)
    {
    this.print(s);
    }
  }
public void print(String s)
  {
  if(s==null) s="NULL";
  fplog.print(this.getClassname() + s);
  fplog.flush();
  }
public void printinfo(String s)
  {
  this.print("Info: " + s,1);
  }
public void printinfo(String classname, String s)
  {
  this.printinfo(classname + ": " + s);
  }
public void printwarn(String s)
  {
  this.print("Warning: " + s, 2);
  }
public void printwarn(String classname, String s)
  {
  this.printwarn(classname + ": " + s);
  }
public void printerr(String s)
  {
  this.print("ERROR: " + s, 3);
  this.displayErr(s);
  }

public void tprint(String s)
  {
  this.print(timeStamp() + " " + s);
  }
public void tprint(String s, int debuglevel)
  {
  this.print(timeStamp() + " " + s, debuglevel);
  }
public void tprintinfo(String s)
  {
  this.tprint("Info: " + s,1);
  }
public void tprintinfo(String classname, String s)
  {
  this.tprintinfo(classname + ": " + s);
  }
public void tprintwarn(String s)
  {
  this.tprint("Warning: " + s, 2);
  }
public void tprintwarn(String classname, String s)
  {
  this.tprintwarn(classname + ": " + s);
  }
public void tprinterr(String s)
  {
  this.tprint("ERROR: " + s, 3);
  this.displayErr(s);
  }


public void println(String s, int debuglevel)
  {
  if(s==null)s="NULL";
  if (debuglevel >= threshold)
    {
    this.println(s);
    }
  }
public void println(String s)
  {
  if(s==null)s="NULL";
  fplog.println(this.getClassname() + s);
  fplog.flush();
  }
public void printlninfo(String s)
  {
  this.println("Info: " + s, 1);
  }
public void printlninfo(String classname, String s)
  {
  this.println("Info: " + classname + ": " + s, 1);
  }
public void i(String s) {this.printlninfo(s);}
public void info(String s) {this.printlninfo(s);}
public void printlnwarn(String s)
  {
  this.println("Warning: " + s, 2);
  }
public void printlnerr(String s)
  {
  this.println("ERROR: " + s, 3);
  this.displayErr(s);
  }
public void err(String s, Exception e) {this.ee(s,e);}
public void e(String s) {this.printlnerr(s);}
public void ee(String s, Exception e) {e.printStackTrace(fplog); this.printlnerr(s);}
public void tprintln(String s)
  {
  this.println(timeStamp() + " " + s);
  }
public void tprintln(String s, int debuglevel)
  {
  this.println(timeStamp() + " " + s, debuglevel);
  }
public void tprintlninfo(String s)
  {
  this.println("Info: " + timeStamp() + ": " + s, 1);
  }
public void tprintlninfo(String classname, String s)
  {
  this.println("Info: " + classname + ": " + timeStamp() + ": " + s, 1);
  }
public void tprintlnwarn(String s)
  {
  this.println("Warn: " + timeStamp() + ": " + s, 2);
  }
public void tprintlnwarn(String classname, String s)
  {
  this.println("Warn: "  + classname + ": " + timeStamp() + ": " + s, 2);
  }
public void tprintlnerr(String s)
  {
  this.println("ERROR: "  + timeStamp() + ": " + s, 3);
  this.displayErr(s);
  }
public void te(String s){this.tprintlnerr(s);}
public void tee(String s, Exception e)
  {
  this.tprintlnerr(s + ":  " + e.getMessage());
  this.println(e.getMessage());
  e.printStackTrace(fplog);
  }



private void displayErr(String s)
  {
  JOptionPane.showMessageDialog(null, s, "ERROR", JOptionPane.ERROR_MESSAGE);
  }

public boolean setThreshold(int thresh)
  {
  if(!checkThresh(thresh)) return false;
  this.threshold=thresh;
  return true;
  }

public int getThreshold() {return this.threshold;}


public boolean closeLogfile()
  {
  fplog.println("End of job " + this.progname1 + " at " + timeStamp());
  fplog.close();
  return true;
  }


public String timeStamp()
  {
  long t = System.currentTimeMillis();
  String tstr = String.valueOf(t);
  tstr = tstr.substring(tstr.length() - 3);
  Date date = new Date();
  Time time1 = new Time(date.getTime());
  return(time1.toString() + "." + tstr);
  }

private boolean checkThresh(int thresh)
  {
  if(thresh < 1 || thresh > 4)
    {
    System.err.println("ERROR: Call to Logfile specified logging threshold of " + thresh + ", valid valued are 1-4.");
    return false;
    }
  return true;
  }

private String getClassname()
  {
  StackTraceElement STE[];
  int stacksize;
  String classname;
  String method=null;
  String parent = null;
  String grandparent = null;
  String lineage="";  // concatentation of grandparent, parent, classname, method
  int sptr=0; // stack pointer
  STE = Thread.currentThread().getStackTrace();
  stacksize=STE.length;
  // System.out.println("stacksize=" + stacksize);
    // logger.tprintln("Stacksize=" + stacksize);
    // classname and method
  for(int x=0; x < stacksize; x++)
    {
    classname=STE[x].getClassName();
    if(!classname.contains("Log.Logfile") && !classname.contains("Thread.getStackTrace()") && !classname.contains("java.lang.Thread")) 
      {
      sptr=x; 
      // System.out.println("sptr=" + sptr + " at classname=" + classname);
      break;
      }
    }
  
  classname = STE[sptr].getClassName();
  // classname=Thread.currentThread().getStackTrace()[3].getClassName() + "." +
  method = STE[sptr].getMethodName();
  classname = classname + "." + method + "()";
  if(classname != null && classname.length() > 45) classname = classname.substring(0,44);
    //  Thread.currentThread().getStackTrace()[3].getMethodName() + "()";
    
  // parent
  if((sptr + 1) < stacksize)
    {
    parent = STE[sptr + 1].getClassName() + "." + STE[sptr + 1].getMethodName() + "()";
    if(parent != null && parent.length() > 55)
      {
      parent = parent.substring(0,54);
      }
    }
  else parent=null;
  
  // grandparent
  //      Thread.currentThread().getStackTrace()[3].getMethodName() + "()";
  if((sptr + 2) < stacksize)
    {
    grandparent = STE[sptr + 2].getClassName() + "." + STE[sptr + 2].getMethodName() + "()";
    if(grandparent != null && grandparent.length() > 55)
      {
      grandparent = grandparent.substring(0, 54);
      }  
    } 
  else grandparent=null;
   if(grandparent != null) lineage = lineage +  grandparent + ":";
   if(parent != null) lineage = lineage + parent + ":";
   if(classname != null) lineage = lineage + classname + ":";
   return lineage;
  }

}  /* end Class Logfile */






