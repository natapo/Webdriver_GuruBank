package project_bankGruru99;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLogin {
	public static void main (String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Natalja\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "http://www.demo.guru99.com/V4/";
		String userId = "mngr152672";
		String password = "YsEnygu";
		String expectedTitle = "Guru99 Bank Manager HomePage";
		String actualTitle = "";
		
		driver.get(baseUrl);
		
		WebElement userIdElement = driver.findElement(By.name("uid"));
		WebElement passwordElement = driver.findElement(By.name("password"));
		WebElement loginElement = driver.findElement(By.name("btnLogin"));
		
		userIdElement.sendKeys(userId);
		passwordElement.sendKeys(password);
		loginElement.click();
		
		actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(expectedTitle)){
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
		}
		
		
		driver.close();
		System.exit(0);
	}

}
