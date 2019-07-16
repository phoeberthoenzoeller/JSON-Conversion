/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v;
import m.Common;
import java.io.File;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import v.Logfile;
import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import v.FileOut;

/**
 *
 * @author Charles Gray
 */
public class SelectJSONFiles
{
Logfile logger;


public SelectJSONFiles()
  {
  this.logger = Common.logger;    
  }



/**
 * User interface to select source JSON file(s) or folder containing those files.
 * @return File[]
 */
public File[] selectJsonFiles()
  {
  logger.println("Begin selectJsonFile");
  JFileChooser jfc = new JFileChooser();
  jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
  jfc.setMultiSelectionEnabled(true);
  File[] fileArray;
  String fileChosen;
  /*
  FileChoose fc = new FileChoose("json",logger);
  String fileRead=fc.open();
  */
  if(jfc.showOpenDialog(jfc) != JFileChooser.APPROVE_OPTION)
    {
    logger.printerr("No JSON input file selected."); return null;  
    }
  fileArray = jfc.getSelectedFiles();
  if(fileArray==null) {logger.printerr("No file selected."); return null;}   
  if(fileArray[0].isDirectory())  // If the user chooses a directory then get all file therein with a suffix of .json
  fileArray=getJsonInDirectory(fileArray[0]);
  // File fileObject=new File(fileRead);  // Instead of utilizing a File we could instead use a URL
  // logger.println("Selected file absolute =" + filel.getAbsolutePath());
  /*
  try{ logger.println("Selected file canonical =" + fileObject.getCanonicalPath());}
  catch(IOException e) {logger.ee("Failed to obtain canonical path for selected file.", e); }
   logger.println("Selected file name =" + fileObject.getName());
    logger.println("Selected file path =" + fileObject.getPath());
    logger.println("Selected file parent =" + fileObject.getParent());
  */
  for(int x=0; x < fileArray.length; x++)logger.println("Selected file[" + x + "]=" + fileArray[x].getAbsolutePath());
  return fileArray;
  }  // end method selectJsonFiles




private File[] getJsonInDirectory(File fileDirectory)
  {
  int jsonCnt=0;  // number of files in chosen directory with files that end with .json
  String fname;
  File[] allFiles;
  File[] jsonFiles;
  int jfCnt=0;
  logger.println("Begin getJsonInDirectory for folder=" + fileDirectory.getAbsolutePath());
  if(!fileDirectory.isDirectory())
    {
    logger.e("Error in getJsonDirectory: " + fileDirectory.getAbsolutePath() + " is not a directory.");
    return null;
    }
  allFiles = fileDirectory.listFiles();
  for(int x=0; x < allFiles.length; x++)
    {
    fname=allFiles[x].getName();
    logger.println("Filename[" + x + "]=" + fname);
    if(fname.endsWith(".json")) jsonCnt++;
    }
  logger.println(jsonCnt + " files found in folder.");
  jsonFiles = new File[jsonCnt];
   for(int x=0; x < allFiles.length; x++)
    {
    fname=allFiles[x].getName();
    if(fname.endsWith(".json")) 
      {
      jsonFiles[jfCnt]=allFiles[x];
      jfCnt++;
      }
    } // end for each file in folder.
  return jsonFiles; 
  }  // end method getJsonInDirectory






}  // end class SelectJSONFiles
