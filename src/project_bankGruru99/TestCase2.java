package project_bankGruru99;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase2 {
	static WebDriver driver;
	static String baseUrl;
	
	public static void driverSetUp() throws Exception {
		//ChromeOptions pathToBinary = new ChromeOptions();
		//pathToBinary.setBinary(Util.CHROMEDRIVER_PATH);
		// ??????????
		System.setProperty("webdriver.chrome.driver", Util.CHROMEDRIVER_PATH);
		driver = new ChromeDriver();
		baseUrl = Util.BASE_URL;
		driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
		driver.get(baseUrl+"/V4/");
	}
	
	
public static void main(String[] args) throws Exception {
	String actualTitle;
	driverSetUp();
	
	WebElement userIdElement = driver.findElement(By.name("uid"));
	WebElement passwordElement = driver.findElement(By.name("password"));
	WebElement loginElement = driver.findElement(By.name("btnLogin"));
	
	userIdElement.clear();
	userIdElement.sendKeys(Util.USER_NAME);
	passwordElement.clear();
	passwordElement.sendKeys(Util.PASSWD);
	loginElement.click();
	
	actualTitle = driver.getTitle();
	if (actualTitle.contentEquals(Util.EXPECTED_TITLE)){
		System.out.println("Test Passed!");
	} else {
		System.out.println("Test Failed!");
	}
	driver.close();
	System.exit(0);
	}
}
