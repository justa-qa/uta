import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.opencart.com");
		
		driver.findElement(By.xpath("//*[@id='currency']/div/button")).click();
		driver.findElement(By.name("GBP")).click();
		
		WebDriverWait wait;
		WebElement search = waitForReload(driver, By.name("search"));
		search.sendKeys("iPod");
		
		System.out.println(search);
		
		driver.findElement(By.xpath("//*[@id='search']/span/button")).click();
		
		waitForReload(driver, By.xpath("//*[@id='search']/span/button"));
		
		driver.findElement(By.xpath("//*[@id='content']/div[4]/div[1]/div/div[3]/button[3]")).click();
		waitForReload(driver, By.cssSelector("div.alert-success"));
		                             
		driver.findElement(By.xpath("//*[@id='content']/div[4]/div[2]/div/div[3]/button[3]")).click();
		
		waitForClickable(driver);
		
		
//		waitForReload(driver, By.cssSelector("div.alert-success"));
//		driver.findElement(By.xpath("//*[@id='content']/div[4]/div[3]/div/div[3]/button[3]")).click();
//		waitForReload(driver, By.cssSelector("div.alert-success"));
//		driver.findElement(By.xpath("//*[@id='content']/div[4]/div[4]/div/div[3]/button[3]")).click();
//		
		
		
		
		driver.findElement(By.id("compare-total")).click();
		
		
		
		

	}

	private static void waitForClickable(WebDriver driver) {
		WebElement clickableElement = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.elementToBeClickable(By.id("compare-total")));
	}

	private static WebElement waitForReload(WebDriver driver, By by) {
		
		WebElement myDynamicElement = (new WebDriverWait(driver, 30))
		  .until(ExpectedConditions.visibilityOfElementLocated(by));
		  return myDynamicElement;
	}

}
