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

public class Ex3 {
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
    public void rightClick() {
    	//Actions class method to drag and drop 
    	Actions actions = new Actions(driver);
    	
    	WebElement rightClick = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
    	actions.contextClick(rightClick).perform();
    	
    	WebElement editBtn = driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-edit']"));
    	editBtn.click();
    	
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
