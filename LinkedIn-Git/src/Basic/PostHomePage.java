package Basic;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class PostHomePage {

	WebDriver driver = null;
	JavascriptExecutor js =null;
	WebDriverWait driverWait = null;
	
	@BeforeTest
	public void setUpTest(){
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Documents\\NH\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		
		//explicit wait
		driverWait = new WebDriverWait(driver, 10);
	}
		
	
	@Test
	public void login() throws Exception {
		
	    driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/login");
        
        WebElement username=driver.findElement(By.id("username"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement login=driver.findElement(By.xpath("//button[text()='Sign in']"));
        
        username.sendKeys("username");
        password.sendKeys("password");
        login.click();
     
        clickOnPost();
        
	}
        public void clickOnPost() throws Exception{

			//explicit wait
	        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Views of your post']")));
			driver.findElement(By.xpath("//span[.='Views of your post']")).click();
			
			Thread.sleep(5000);
			
	        //explicit wait
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.see-more")));
			driver.findElement(By.cssSelector("button.see-more")).click();
	
			//scrolling post - as in reading
			js.executeScript("scroll(0, 100)");
			
			driver.findElement(By.id("feed-nav-item")).click();
	}
		

	@AfterTest	
	public void tearDownTest(){
		driver.close();
	}
}