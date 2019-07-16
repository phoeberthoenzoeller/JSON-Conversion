/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;
import m.Common;
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
public class JSON_HTML
{
public String LabelColor;  // Default to black. assigned by Preferences.
public String ValueColor;  // Default to black.  assigned by Preferences
public String ProjectNameColor;  // Default to black.  assigned by Preferences
private Logfile logger;
public File[] filesJSON;  // created in v.SelectJSONFiles.  Passed here by UI.
private JSONObject jol;
private String HTMLString;
private String projectName;
private String favorited;



public JSON_HTML()
  {
  this.logger = Common.logger;
  
 
  }


/**
 * Called exclusively by UI
 * @return number of files converted.
 */
public int convert()
  {
  int filesConverted=0;
  if(this.filesJSON==null) 
    {
    logger.e("Convert called with no files in list to convert.");
    return 0;
    }
  for(int x=0; x < this.filesJSON.length; x++)
    {
    this.jol=this.fileToJsonobject(this.filesJSON[x]);  // Obtain a JSONObject from the File object.
    if(this.jol==null) 
      {
      logger.e("Failed to convert file " + this.filesJSON[x].getName());
      continue;
      }
    this.editJSON(this.jol);
    this.HTMLString=this.jsonToHtml(this.jol);  // Convert JSONObject to HTML
    this.HTMLString=this.editHTML(this.HTMLString, this.projectName);
    this.htmlToFile(this.filesJSON[x], this.projectName, this.HTMLString);
    filesConverted++;
    }
  this.cssToFile(this.filesJSON[0]);  
  return filesConverted;
  }





/**
 * Read JSON file into a String object and then convert to JSON object;
 * @param File JSON source file.
 * @return JSONObject
 */
private JSONObject fileToJsonobject(File jsonFile)
  {
  logger.println("Begin fileToJsonobject");
  FileInputStream fis;
  FileReader fin;
  char[] ca;
  JSONObject jolly;
  try
    {
    fis = new FileInputStream(jsonFile);
    fin = new FileReader(jsonFile);  // read single character, char[],
    int x = fis.available();
    ca = new char[x];
    fin.read(ca);
    }
  catch (IOException e)
    {
    logger.ee("Cannot read " + jsonFile.getName() + " for read. IOException=",e);
    return null;
    }
  String jsonString = String.valueOf(ca);
  try{jolly = new JSONObject(jsonString);}
  catch(JSONException jse){logger.ee("Failed to read file=" + jsonFile.getName() 
    + "\n"  + "This file does not appear to be a JSON file." + "\n" + jse.getMessage(), jse); return null;}
   logger.println("Completed fileToJsonobject");
  return jolly;
  }








/**
 * User notes are included in the knitting site dump file twice,
 * once as DOS text (label notes) and once as HTML(label notes_html)
 * We will delete the text version.
 * Also, this method assigns this.projectName if a label "name" is found in JSON file.
 */
JSONObject editJSON(JSONObject jolly)
  {
  logger.println("Begin editJSON");
  JSONArray jsaFavorited=null;
  jolly.remove("notes");
  this.getValueForLabel(jolly, "favorited");
  this.getJSONArrayForLabel(jolly, "favorited");
  this.getValueForLabel(jolly, "created_at");
  if(jsaFavorited != null) logger.println("favorited array contains " + jsaFavorited.length() + " elements.");
  else logger.println("favorited array label not found.");
  this.projectName = this.getValueForLabel(jolly, "name");
  logger.println("Completed editJSON");
  return jolly;
  }


/**
 * Find label in JSON file and return value assigned to that label.
 * If label is not found then return null.
 * @param JSONObject jsol
 * @param String labell
 * @return String value attributed in JSON file to label
 */
private String getValueForLabel(JSONObject jsol, String labell)
  {
  String value=null;
  try{value = jsol.getString(labell);}
  catch(JSONException npe)
    {
    logger.println(labell + " label not found in JSON file."); 
    return null;
    }
  catch(NullPointerException npe)
    {
    logger.println(labell + " label not found in JSON file."); 
    return null;
    }  
  if(value==null) logger.println("Label " + labell + " was not found.");
  else {logger.println("Label " + labell + " has assigned to it a value of " + value);}
  return value;
  }





/**
 * Find label in JSON file and return JSONArray assigned to that label.
 * If label is not found then return null.
 * @param JSONObject jsol
 * @param String labell
 * @return JSONArray
 */
private JSONArray getJSONArrayForLabel(JSONObject jsol, String labell)
  {
  String value=null;
  JSONArray jsonal;
  try{jsonal = jsol.getJSONArray(labell);}
  catch(JSONException npe)
    {
    logger.println(labell + " JSONArray not found in JSON file."); 
    return null;
    }
  catch(NullPointerException npe)
    {
    logger.println(labell + " JSONArray not found in JSON file."); 
    return null;
    }  
  if(value==null) logger.println("JSONArray " + labell + " was not found.");
  else {logger.println("JSONArray " + labell + " contains " + jsonal.length() + " elements.");}
  return jsonal;
  }




/**
 * Edit the HTML
 * Add a header referencing the json.css file.
 */
String editHTML(String htmls, String projectNamel)
  {
  logger.println("Begin editHTML");
  String charset = "<meta charset=\"UTF-8\">" + "\n";
  String headerProject="";
  //if(projectNamel!= null) headerProject = "<h4> " + projectNamel + " </h4>" + "\n";
  if(projectNamel!= null) headerProject = "<h4 class=\"project_name\">" + projectNamel + " </h4>" + "\n";
  String headercss = "<head><link rel=\"stylesheet\" type=\"text/css\" href=\"json.css\" media=\"screen\" /></head>" + "\n";
  htmls = charset + headerProject + headercss + htmls;
  htmls = htmls.replace("<h1", "<h1 style=\"font-size:14px;\"");  // reduce the size of the dates found in notes.
 // htmls = htmls.replace("</h1>\\n\\n", "</h1>\\n"); // take out a blank line after the date in notes.
  htmls = htmls.replace("</h1>\n\n", "</h1>");
  logger.println("Completed editHTML");
  return htmls;
  }

/**
 * convert json Data to structured Html text
 * 
 * @param json
 * @return string
 */
private String jsonToHtml( Object obj ) 
  {
  // this method is called recursively and so I don't log entry/exit.
  StringBuilder html = new StringBuilder( );
  try 
    {
    if (obj instanceof JSONObject) 
      {
      JSONObject jsonObject = (JSONObject)obj;
      String[] keys = JSONObject.getNames( jsonObject );
      html.append("<div class=\"json_object\">");
      if (keys.length > 0) 
        {
        for (String key : keys) 
          {
          // print the key and open a DIV
          html.append("<div><span class=\"json_key\">").append(key).append("</span> : ");
 
          Object val = jsonObject.get(key);
          // recursive call
          html.append( jsonToHtml( val ) );
          // close the div
          html.append("</div>");
          }
        }  // end if block

      html.append("</div>");

      }  // end block if instanceof JSONOBJECT
    else if (obj instanceof JSONArray) 
      {
      JSONArray array = (JSONArray)obj;
      for ( int i=0; i < array.length( ); i++) 
        {
        // recursive call
        html.append( jsonToHtml( array.get(i) ) );                    
        }
      } // end block if instanceof JSONARRAY
    else 
      {
      // print the value
      html.append( obj );
      }                
    }  // end try block
  catch (JSONException e) { return e.getLocalizedMessage( ) ; }
  return html.toString();
  }  // end method jsonToHTML
      


/**
 * Write HTML to file.
 * The name of the file is obtained by reading the json tag "name".
 * The file is written to folder holding the source json file.
 */      
private boolean htmlToFile(File fileJsonl, String projectNamel, String htmls)
  {
  logger.println("Begin htmlToFile for file=" + fileJsonl.getAbsolutePath() + " and project name=" + projectNamel);
  String filename;
  if(projectNamel != null) 
    {
    projectNamel = projectNamel.replaceAll("\\s+", "_");
    filename = fileJsonl.getParent() + "/" + projectNamel + ".html";
    }
  else
    {
    filename = fileJsonl.getAbsolutePath();
    if(filename.endsWith("json")) 
        {
        // filename = filename.replace("json", "html");
        filename = filename.substring(0,filename.length()-4) + "html";
        }
    else filename += ".html";
    }
  logger.println("Writing output html to file name=" + filename);
  FileOut fout = new FileOut(logger,filename, htmls);  
  if(fout.status==false) {logger.e("Failed to write file " + projectNamel); return false;}
  logger.println("Completed htmlToFile");
  return true;
  }

/**
 * Write the css file.
 */
private boolean cssToFile(File fileJsonl)
  {
  logger.println("Begin cssToFile.  ProjectNameColor=" + this.ProjectNameColor 
    + ", ValueColor=" + this.ValueColor + ", LabelColor=" + this.LabelColor);
  String cssString="";
  if(this.ProjectNameColor != null )
      cssString = ".project_name{color: " + this.ProjectNameColor + "}\n";
  cssString += ".json_object { margin:10px; padding-left:10px; border-left:1px solid #ccc";
  if(this.ValueColor != null) cssString += " ;color:" + this.ValueColor;
  cssString += "}\n"     + ".json_key { font-weight: bold;";
  if(this.LabelColor != null) cssString += " color:" + this.LabelColor;
  cssString += "}";
  String filename = fileJsonl.getParent() + "/json.css";
  logger.println("Writing output .css to file name=" + filename);
  FileOut fout = new FileOut(logger,filename, cssString);  
  if(fout.status==false) {logger.e("Failed to write file " + filename); return false;}
  logger.println("Completed cssToFile.  File written to name=" + filename);
  return true;  
  }
}  // end class JSON_HTML
