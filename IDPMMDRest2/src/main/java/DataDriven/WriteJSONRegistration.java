package DataDriven;
 
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
//import java.security.Timestamp;
//import java.security.Timestamp;
import java.time.Instant;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

//import com.newtour.genric.ExcelData;
 
public class WriteJSONRegistration
{
	//JSONObject obj=new JSONObject();  
	Instant instant = Instant.now() ;
	 Random rand = new Random();
	//10000 + new Random().nextInt(90000);
    //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	String time = instant.toString() ;
	String firstname = "John" + time;
	String lastname = "Cena" + time;
	int Phone1=1000000000 + rand.nextInt(1000000000);
	String EMAIL= "Avinash13ruth@gmail.com";
	String ADDRESS= "No 21 NK palya";
	String CITY="Bangalore";
	String STATE="Karnataka";
	int PostalCode1= rand.nextInt(500000);
	//String VISIBLETEXT=ExcelData.getData(path,"Register", 1,8);
	String USER_NAME= firstname;
	String PASSWORD= "Welcome@123";
	JSONParser jsonParser = new JSONParser();
	JSONObject fileread = new JSONObject();
	//String CONFIRM=ExcelData.getData(path,"Register",1,11);
	//@SuppressWarnings("unchecked")
		
	public HashMap<String, String> getRegistrationData(String Filepath)
		{
		
	      try {
		         //Parsing the contents of the JSON file
		      fileread = (JSONObject) jsonParser.parse(new FileReader(Filepath));
		        
		      }
		      catch (FileNotFoundException e) {
		            e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      } catch (ParseException e) {
		         e.printStackTrace();
		      }
			/*String firstname = obj.get("firstname").toString();
			String lastname = obj.get("lastname").toString();
			String PHONE =  obj.get("PHONE").toString();
			String EMAIL = obj.get("EMAIL").toString();
			String ADDRESS = obj.get("ADDRESS").toString();
			String CITY = obj.get("CITY").toString();
			String STATE = obj.get("STATE").toString();
			String POSTALCODE = obj.get("POSTALCODE").toString();
			String USER_NAME = obj.get("USER_NAME").toString();
			String PASSWORD = obj.get("PASSWORD").toString();*/

	      	String firstname1 = firstname.toString();
	        String lastname1 = lastname.toString();
			String PHONE1 =  Integer.toString(Phone1);
			String EMAIL = fileread.get("EMAIL").toString();
			String ADDRESS = fileread.get("ADDRESS").toString();
			String CITY = fileread.get("CITY").toString();
			String STATE = fileread.get("STATE").toString();
			String POSTALCODE1 = Integer.toString(PostalCode1);
			String USER_NAME1 = USER_NAME.toString();
			String PASSWORD = fileread.get("PASSWORD").toString();
			HashMap<String, String> m1 = new HashMap<String, String>(); 
		     m1.put("firstname", firstname1);  
		      m1.put("lastname",lastname1);  
			  m1.put("PHONE",PHONE1); 
			  m1.put("EMAIL",EMAIL);  
			  m1.put("ADDRESS",ADDRESS);  
			 m1.put("CITY",CITY);
			 m1.put("STATE",STATE);
			 m1.put("POSTALCODE",POSTALCODE1);
			 m1.put("USER_NAME",USER_NAME1);  
			  m1.put("PASSWORD",PASSWORD);
		
			return m1;
			  
		}
	public HashMap<String, String> getFlightData(String Filepath)
	{
	
      try {
	         //Parsing the contents of the JSON file
	      fileread = (JSONObject) jsonParser.parse(new FileReader(Filepath));
	        
	      }
	      catch (FileNotFoundException e) {
	            e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (ParseException e) {
	         e.printStackTrace();
	      }
	
     
      String TYPE = fileread.get("TYPE").toString();
        String PASSENGERS = fileread.get("PASSENGERS").toString();	
		String DEPARTINGFROM =  fileread.get("DEPARTINGFROM").toString();
		String ONMONTH = fileread.get("ONMONTH").toString();
		String ONDATE = fileread.get("ONDATE").toString();
		String ARRIVINGIN = fileread.get("ARRIVINGIN").toString();
		String RETURNINGMONTH = fileread.get("RETURNINGMONTH").toString();
		String RETURNINGDAY = fileread.get("RETURNINGDAY").toString();
		String CLASS = fileread.get("CLASS").toString();
		String AIRLINE = fileread.get("AIRLINE").toString();
		HashMap<String, String> m1 = new HashMap<String, String>(); 
	     m1.put("TYPE", TYPE);  
	      m1.put("PASSENGERS",PASSENGERS);  
		  m1.put("DEPARTINGFROM",DEPARTINGFROM); 
		  m1.put("ONMONTH",ONMONTH);  
		  m1.put("ONDATE",ONDATE);  
		 m1.put("ARRIVINGIN",ARRIVINGIN);
		 m1.put("RETURNINGMONTH",RETURNINGMONTH);
		 m1.put("RETURNINGDAY",RETURNINGDAY);
		 m1.put("CLASS",CLASS);  
		  m1.put("AIRLINE",AIRLINE);
	
		return m1;
		  
	}
}
