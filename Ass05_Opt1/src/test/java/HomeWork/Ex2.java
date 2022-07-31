package HomeWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ex2 {
	WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/simple_context_menu.html"); 
    }
    
    @Test
    public void doubleClick() {
    	//Actions class method to drag and drop 
    	Actions actions = new Actions(driver);
    	
    	WebElement doubleClickbtn = driver.findElement(By.xpath("//button[normalize-space()='Double-Click Me To See Alert']"));
    	actions.doubleClick(doubleClickbtn).perform();
    	
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//Alert
    	Alert alert = driver.switchTo().alert();
    	System.out.println("Nội dung đã lấy trong Popup: "+alert.getText());
    	alert.accept();
    }
    
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
