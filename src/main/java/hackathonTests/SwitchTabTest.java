package hackathonTests;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchTabTest{
	public static WebDriver driver;
	
   public static void main(String[] args) throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
      driver.get("https://selenium-prd.firebaseapp.com/home.html");
      Thread.sleep(5000);
      //Create a new TAB
      driver.switchTo().newWindow(WindowType.TAB);
      driver.get("https://login.salesforce.com");
      Thread.sleep(5000);
      //Create a new WINDOW
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      driver.switchTo().newWindow(WindowType.WINDOW);
      driver.get("https://google.com");
      Thread.sleep(5000);
      //Iterate through all window IDs
      Set<String> allWindows = driver.getWindowHandles();
      java.util.Iterator<String> Iterator = allWindows.iterator();
      
      List<String> windowsList = new ArrayList<String>();
      while(Iterator.hasNext()) {
    	  windowsList.add(Iterator.next());
      }
      //Verify each tab/window by getting their titles
      driver.switchTo().window(windowsList.get(0));
      System.out.println("First window title: "+driver.getTitle());
      driver.close();
      Thread.sleep(2000);
      driver.switchTo().window(windowsList.get(1));
      System.out.println("Second window title: "+driver.getTitle());
      driver.switchTo().window(windowsList.get(2));
      System.out.println("First window title: "+driver.getTitle());
      driver.quit();
   }
}
