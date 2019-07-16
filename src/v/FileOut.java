package v;

/** Class FileOut
 * Prints strings or byte arrays to a String fileout filename.
 * Constructor FileOut(String filename);
 * Method boolean write(String textout); return false for failure.
 * Throws IOException.  
 * This class creates PrintWriter, FileWriter, FileOutputStream, and BufferedWriter(PrintWriter) objects.
 * In general, a Writer sends its output immediately to the underlying character or byte stream. 
 * FileWriter is the character representation of IO. That means it can be used to write characters. Internally FileWriter would use the default character set of the underlying OS and convert the characters to bytes and write it to the disk.
 * PrintWriter & FileWriter.
 * Similarities
 * Both extend from Writer.
 * Both are character representation classes, that means they work with characters and convert them to bytes using default charset.
 * Differences
 * FileWriter throws IOException in case of any IO failure, this is a checked exception.
 * None of the PrintWriter methods throws IOException , instead they set a boolean flag which can be obtained using checkError().
 * PrintWriter has on optional constructor you may use to enable auto-flushing when specific methods are called. No such option exists in FileWriter.
 * When writing to files, FileWriter has an optional constructor which allows it to append to the existing file when the "write()" method is called.
 * Difference between PrintStream and OutputStream: Similar to above explanation, just replace character with byte.
 * PrintWriter has following methods :
 * close()
 * flush()
 * format()
 * printf()
 * print()
 * println()
 * write()

 * and constructors are :
 * File (as of Java 5)
 * String (as of Java 5)
 * OutputStream
 * Writer
 * while FileWriter has following methods :
 *close()
 * flush()
 * write()
 * and constructors are :
 * File
 * String 
 */




import java.io.*;
import v.Logfile;

/**
 * Constructor that creates streams only.  Use method FileOut to write file.
 * @author chas
 */
public class FileOut
  {
  private PrintWriter pw;
  private BufferedWriter bw;
  private FileOutputStream fos;
  private Logfile logger;
  public boolean status;
  private FileWriter fw;
  private String fileName;
  
  
/**
 * Constructor to write String to fileName
 * To determine success check public boolean status.
 */
public FileOut(Logfile logger, String fileName, String textout)   
  {
  this.logger = logger;
  if(this.FileOut(fileName,textout)) this.status=true;
  else status=false;
  this.close();
  }

/**
 * Constructor to set output FileOutputStream.
 * Call method writeString(String) to output text to the file.
 */
public FileOut(Logfile logger, String fileName)
  {
  this.logger = logger;
  if(this.createStream(fileName)) this.status=true;
  else status=false;
  }


/**
 * 
 * @param fileName Full name of file to receive text
 * @param textout String
 * @return boolean success
 */
public boolean FileOut(String fileName, String textout) 
    {
    if(!this.createStream(fileName)) return false;
    logger.println("Begin output of text.");
    this.pw.print(textout);
    if (this.pw.checkError() == true) {logger.e("ERROR writing contents of file=" + fileName);this.status=false; return false;}
    logger.println("Complete output of text.");
    return true;
    } // end FileOut


/**
 * Creates FileWriter, PrintWriter, and FileOutputStream.
 * Call method writeString(String) to output to this file.
 * @param fileName
 * @return 
 */
public boolean createStream(String fileName)
  {
  this.fileName=fileName;
  try
    {
    this.fw = new FileWriter(fileName);
    this.pw = new PrintWriter(this.fw);
    this.fos = new FileOutputStream(fileName);
    this.bw = new BufferedWriter(this.pw);
    }
  catch (IOException e)
    {
    logger.ee("ERROR: In FileOut: Cannot open file " + fileName + " for write.",e);
    this.status=false;
    return false;
    }
  if(this.pw==null)    {logger.println("ERROR: In FileOut: Failed to create PrintWriter for  " + fileName); this.status=false; return false;}
  if(this.fos==null)   {logger.println("ERROR: In FileOut: Failed to create FileOutputStream for  " + fileName); this.status=false; return false;}
  return true;
  }



public boolean writeString(String textout)
  {
  this.pw.print(textout);
  if (this.pw.checkError() == true) return false;
  return true;
  }

public boolean writeln(String textout)
  {
  this.pw.println(textout);
  if (this.pw.checkError() == true) return false;
  return true;
  }

public boolean writeByteArray(byte[] barray)
  {
  if(barray==null)
    {
    logger.e("ERROR in FileOut: null array passed to writeByteArray().");
    return false;
    }
  if(fos==null)
    {
    logger.e("ERROR in FileOut: FileOutputStream is null in writeByteArray().");
    return false;
    }
  try{fos.write(barray);}
  catch(IOException IOE)
    {
    logger.ee("ERROR in FileOut: writeByteArray() produced IOException " + IOE.getMessage(),IOE);
    return false;
    }
  return true;
  }

public void close()
  {
   try
     {
     this.fos.close(); 
     this.pw.close();
     this.fw.close();
     }
   catch(IOException IOE)
     {
     logger.ee("ERROR closing file=" + this.fileName, IOE);
     }
  }

}  /* end class Fileout */
