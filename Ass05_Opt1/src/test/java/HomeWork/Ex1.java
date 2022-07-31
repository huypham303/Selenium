package HomeWork;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ex1 {
	WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(" http://demo.guru99.com/test/drag_drop.html"); 
    }
    
    @Test
    public void dragAndDrop() {
    	//Actions class method to drag and drop 
    	Actions builder = new Actions(driver);
    	
    	WebElement obj5000 = driver.findElement(By.xpath("//section[@id='g-container-main']//li[2]//a[1]"));
    	WebElement spacElement = driver.findElement(By.xpath("//ol[@id='amt7']"));
    	WebElement getTextElement = driver.findElement(By.xpath("//div[@id='t7']"));
    	//Perform drag and drop
    	builder.dragAndDrop(obj5000, spacElement).perform();
    	
    	System.out.println("Đã lấy: "+getTextElement.getText());
    }
    
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
	

}
