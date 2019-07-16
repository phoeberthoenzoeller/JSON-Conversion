/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;
import v.Logfile;
import m.Common;
import v.UI;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import v.Logfile;


/**
 *
 * @author Charles Gray
 */
public class JSON
{

public JSON(String args[])
  {
  Common.logger = new Logfile("JSON.log", "JSON");  
  UI userIntf = new UI();
  }
    
    
/**
  * @param args the command line arguments
  */
public static void main(String[] args)
  {
  JSON json = new JSON(args);
  }
    
}  // end class JSON_HTML
