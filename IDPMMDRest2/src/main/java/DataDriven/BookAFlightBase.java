package DataDriven;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.awt.event.KeyEvent;

public class BookAFlightBase
{
 ChromeDriver driver;
 HashMap<String, String> registrationData = new HashMap<String, String>(); 
 HashMap<String, String> FlightData = new HashMap<String, String>(); 
 String USER_NAME;
 String PASSWORD;
 String lastname;
 String firstname;
 String PHONE;
 String ADDRESS;
 String CITY;
 String POSTALCODE;
 String STATE;
/*@BeforeMethod
 void Programstart()
 {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Qapitol\\Documents\\Dependencies\\BrowserDependency\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("http://newtours.demoaut.com/");
	 driver.manage().window().maximize();
      
 }*/
 
 @Test(priority = 1)
 public void Registration() throws InterruptedException
 {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Qapitol\\Documents\\Dependencies\\BrowserDependency\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("http://newtours.demoaut.com/");
	 driver.manage().window().maximize();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//*[text()='REGISTER']")).click();
	 //WriteJSONRegistration write = new WriteJSONRegistration();
	 //write.WriteRegistration();
	 //Map<String, String> registrationData = new HashMap<>();
	 //registrationData = write.getRegistrationData();
	 Thread.sleep(5000);
	 firstname= registrationData.get("firstname").toString();
	 System.out.println(firstname);
	 lastname = registrationData.get("lastname").toString();
	 PHONE =  registrationData.get("PHONE").toString();
	 String EMAIL = registrationData.get("EMAIL").toString();
	 ADDRESS = registrationData.get("ADDRESS").toString();
	 CITY =registrationData.get("CITY").toString();
	 STATE = registrationData.get("STATE").toString();
	 POSTALCODE = registrationData.get("POSTALCODE").toString();
	 USER_NAME = registrationData.get("USER_NAME").toString();
	 PASSWORD = registrationData.get("PASSWORD").toString();
	 driver.findElement(By.name("firstName")).sendKeys(firstname);
	 driver.findElement(By.name("lastName")).sendKeys(lastname);
	 driver.findElement(By.name("phone")).sendKeys(PHONE);
	 driver.findElement(By.name("userName")).sendKeys(EMAIL);
	 driver.findElement(By.name("address1")).sendKeys(ADDRESS);
	 driver.findElement(By.name("city")).sendKeys(CITY);
	 driver.findElement(By.name("state")).sendKeys(STATE);
	 driver.findElement(By.name("postalCode")).sendKeys(POSTALCODE);
	 Select s = new Select(driver.findElement(By.name("country"))); 
	 s.selectByVisibleText("INDIA");
	 driver.findElement(By.name("email")).sendKeys(USER_NAME);
	 driver.findElement(By.name("password")).sendKeys(PASSWORD);
	 driver.findElement(By.name("confirmPassword")).sendKeys(PASSWORD);
	 driver.findElement(By.name("register")).click();
	 Assert.assertTrue(driver.getTitle().matches("Register: Mercury Tours"));
	driver.quit();
 }
 
 @Test(priority = 2, dependsOnMethods = { "Registration" } )
 public void LoginSuccessful() throws InterruptedException
 {
// driver.get("http://newtours.demoaut.com/");
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Qapitol\\Documents\\Dependencies\\BrowserDependency\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("http://newtours.demoaut.com/");
	 driver.manage().window().maximize();
	 driver.findElement(By.name("userName")).sendKeys(USER_NAME);
	 driver.findElement(By.name("password")).sendKeys(PASSWORD);
	 driver.findElement(By.name("login")).click();
	 Thread.sleep(5000);
	 Assert.assertTrue(driver.getTitle().matches("Find a Flight: Mercury Tours:"), "Invalid credentials");
	 System.out.println("Login successful");
	 driver.quit();
 }
 
 @Test(priority = 3, dependsOnMethods = { "LoginSuccessful" } )
 public void FlightRegistration() throws AWTException, InterruptedException
 {
// driver.get("http://newtours.demoaut.com/");
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Qapitol\\Documents\\Dependencies\\BrowserDependency\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("http://newtours.demoaut.com/");
	 driver.manage().window().maximize();
	 String TYPE = FlightData.get("TYPE").toString();
	 String PASSENGERS =  FlightData.get("PASSENGERS").toString();
	 String DEPARTINGFROM = FlightData.get("DEPARTINGFROM").toString();
	 String ONMONTH = FlightData.get("ONMONTH").toString();
	 String ONDATE =FlightData.get("ONDATE").toString();
	 String ARRIVINGIN = FlightData.get("ARRIVINGIN").toString();
	 String RETURNINGMONTH = FlightData.get("RETURNINGMONTH").toString();
	 String RETURNINGDAY = FlightData.get("RETURNINGDAY").toString();
	 String CLASS = FlightData.get("CLASS").toString();
	 String AIRLINE = FlightData.get("AIRLINE").toString();
	 String AIRLINE2 = FlightData.get("AIRLINE").toString();
	 driver.findElement(By.name("userName")).sendKeys(USER_NAME);
	 driver.findElement(By.name("password")).sendKeys(PASSWORD);
	 driver.findElement(By.name("login")).click();
	 Thread.sleep(5000);
	 if(TYPE.equals("oneway"))
	 {
		 driver.findElement(By.xpath("//input[@value='oneway']")).click();
	 }
	 else if (TYPE.equals("twoway"))
	 {
		 driver.findElement(By.xpath("//input[@value='twoway']")).click();
	 }
	Select passenger = new Select(driver.findElement(By.name("passCount")));
	System.out.println(DEPARTINGFROM + ONMONTH + ONDATE+ARRIVINGIN+RETURNINGMONTH+RETURNINGDAY);
	passenger.selectByVisibleText(PASSENGERS);
	Select DepartingFrom = new Select(driver.findElement(By.name("fromPort")));
	DepartingFrom.selectByVisibleText(DEPARTINGFROM);
 	Select DepartingOn = new Select(driver.findElement(By.name("fromMonth")));
 	DepartingOn.selectByVisibleText(ONMONTH);
 	Select DepartingOn2 = new Select(driver.findElement(By.name("fromDay")));
 	DepartingOn2.selectByVisibleText(ONDATE);
 	Select DepartingTo = new Select(driver.findElement(By.name("toPort")));
 	DepartingTo.selectByVisibleText(ARRIVINGIN);
 	Select ArriveOn = new Select(driver.findElement(By.name("toMonth")));
 	ArriveOn.selectByVisibleText(RETURNINGMONTH);
 	Select Arriveon2 = new Select( driver.findElement(By.name("toDay")));
 	Arriveon2.selectByVisibleText(RETURNINGDAY);
 	
 	if(CLASS.equals("Business"))
 	{
 		driver.findElement(By.xpath("//input[@value='Business']")).click();
 	}
 	else if(CLASS.equals("Economy"))
 	{
 		driver.findElement(By.xpath("//input[@value='Coach']")).click();
 	}
 	else if(CLASS.equals("First"))
 	{
 		driver.findElement(By.xpath("//input[@value='First']")).click();
 	}
 //driver.findElement(By.name("servClass")).click();
 	if(AIRLINE.equals("Unified Airline"))
 	{
 		Select Airline = new Select(driver.findElement(By.name("airline")));
 		Airline.selectByVisibleText("Unified Airline");
 	}
 	else if (AIRLINE.equals("Blue SKies Airlines"))
 	{
 		Select Airline = new Select(driver.findElement(By.name("airline")));
 		Airline.selectByVisibleText("Blue SKies Airlines");
 	}
 	else if (AIRLINE.equals("Pangea Airlines"))
 	{
 		Select Airline = new Select(driver.findElement(By.name("airline")));
 		Airline.selectByVisibleText("Pangea Airlines"); 
 	} 
 	else
 	{
 		Select Airline = new Select(driver.findElement(By.name("airline")));
 		Airline.selectByVisibleText("No Preference");
 	}
 	driver.findElement(By.name("findFlights")).click();
 
 
 	Thread.sleep(5000);
 
 	if(AIRLINE.equals("Blue Skies Airline"))
 	{
 		driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$360$270$5:03']")).click();
 	}
 	else if (AIRLINE.equals("Unified Airlines"))
 	{
 		driver.findElement(By.xpath("//input[@value='Unified Airlines$363$281$11:24']")).click();
 	}
 	else if (AIRLINE.equals("Pangea Airlines"))
 	{
 		driver.findElement(By.xpath("//input[@value='Pangea Airlines$362$274$9:17']")).click();
 	} 
 	else
 	{
 		driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$361$271$7:10']")).click();
	}
 
 
 	if(AIRLINE2.equals("Unified Airline"))
 	{
 		driver.findElement(By.xpath("//input[@value='Unified Airlines$633$303$18:44']")).click();
 	}
 	else if (AIRLINE2.equals("Blue SKies Airlines"))
 	{
 		driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$630$270$12:23']")).click();
 	}
 	else if (AIRLINE2.equals("Pangea Airlines"))
 	{
 		driver.findElement(By.xpath("//input[@value='Pangea Airlines$632$282$16:37']")).click();
 	} 
 	else
 	{
 		driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$630$270$12:23']")).click();
	
 	}
 
 driver.findElement(By.name("reserveFlights")).click();
 
 Thread.sleep(5000);
 
 driver.findElement(By.name("passFirst0")).sendKeys(firstname);
 
 driver.findElement(By.name("passLast0")).sendKeys(lastname);

 driver.findElement(By.name("creditnumber")).sendKeys(PHONE);
 
  
 Select s3 = new Select(driver.findElement(By.name("cc_exp_dt_mn"))); 
 s3.selectByVisibleText("11");
 Select s4 = new Select(driver.findElement(By.name("cc_exp_dt_yr"))); 
 s4.selectByVisibleText("2009");
 
 driver.findElement(By.name("billAddress1")).clear();
 driver.findElement(By.name("billAddress1")).sendKeys(ADDRESS);
 driver.findElement(By.name("billCity")).clear();
 driver.findElement(By.name("billCity")).sendKeys(CITY);
 driver.findElement(By.name("billState")).clear(); 
 driver.findElement(By.name("billState")).sendKeys(STATE);
 driver.findElement(By.name("billZip")).clear();
 driver.findElement(By.name("billZip")).sendKeys(POSTALCODE);
 
 //Select s5 = new Select(driver.findElement(By.name("billCountry"))); 
 //s5.selectByVisibleText("INDIA");
 driver.findElement(By.name("delAddress1")).clear();
 driver.findElement(By.name("delAddress1")).sendKeys(ADDRESS);
 driver.findElement(By.name("delCity")).clear();
 driver.findElement(By.name("delCity")).sendKeys(CITY);
 driver.findElement(By.name("delState")).clear();
 driver.findElement(By.name("delState")).sendKeys(STATE);
 driver.findElement(By.name("delZip")).clear();
 driver.findElement(By.name("delZip")).sendKeys(POSTALCODE);
// Select s2 = new Select(driver.findElement(By.name("delCountry"))); 
 //s2.selectByVisibleText("INDIA");
 driver.findElement(By.name("buyFlights")).click();
 Thread.sleep(5000);
 JavascriptExecutor js = (JavascriptExecutor)driver;
 js.executeScript("window.print=function(){}");
 /*driver.switchTo().frame("pdf-viewer");
 
 Robot robot = new Robot();
 robot.keyPress(KeyEvent.VK_ENTER);*/

 
 driver.findElement(By.xpath("//img[@src='/images/forms/Logout.gif']")).click();
 Assert.assertTrue(driver.getTitle().matches("Sign-on: Mercury Tours"));
 Thread.sleep(5000);
 
 driver.quit();
 }
 
 
 @Test(dataProvider="testdata", priority = 4)
 public void LoginValidation(String username, String password) throws InterruptedException
 {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Qapitol\\Documents\\Dependencies\\BrowserDependency\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("http://newtours.demoaut.com/");
	 driver.manage().window().maximize();
  
	 driver.findElement(By.name("userName")).sendKeys(username);
	 driver.findElement(By.name("password")).sendKeys(password);
	 driver.findElement(By.name("login")).click();
	 Thread.sleep(5000);
	 Assert.assertTrue(driver.getTitle().matches("Sign-on: Mercury Tours"), "Invalid credentials");
	 System.out.println("Login unsuccessful");
	 driver.quit();
 }


 
 //Data Extractors
 @Test() 
 public void RegistrationData()
 {
	 WriteJSONRegistration write = new WriteJSONRegistration();
	// write.WriteRegistration();
	 registrationData = write.getRegistrationData("C:/Users\\\\\\\\Qapitol\\\\\\\\eclipse-workspace\\\\\\\\IDPMMDRest2\\\\\\\\Registration details.json");
	 System.out.println("Working map");
	 System.out.print("\t" + registrationData);
 }
 
 @Test() 
 public void FlightData()
 {
	 WriteJSONRegistration write = new WriteJSONRegistration();
	// write.WriteRegistration();
	 FlightData = write.getFlightData("C:\\Users\\Qapitol\\eclipse-workspace\\IDPMMDRest2\\Flight details.json");
	 System.out.println("Working Flight map");
	 System.out.print("\t" + FlightData);
 }
 
@DataProvider(name="testdata")
public Object[][] TestDataFeed()
 {
 ReadExcelFile config = new ReadExcelFile("C:\\Users\\Qapitol\\Documents\\Automation Exercise\\User Credentials.xlsx");
 int rows = config.getRowCount(0);
 
 //System.out.println(cols);
 Object[][] credentials = new Object[rows][2];
 
 for(int i=0;i < rows;i++)
 {
 credentials[i][0] = config.getData(0, i, 0);
 credentials[i][1] = config.getData(0, i, 1); 
 }
 return credentials;
 }
 
}
