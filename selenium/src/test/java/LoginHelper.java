package steps;

import java.io.File;
import java.io.InputStream;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class LoginHelper {
    ChromeOptions opt=new ChromeOptions();
    WebDriver driver=null;

    public LoginHelper() throws InterruptedException {


            @SuppressWarnings("unused")
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("chromedriver.exe");

            // Mengkonversi InputStream ke File
            File driverFile = new File("src/test/resources/driver/chromedriver.exe");
            opt.addArguments("--remote-allow-origins=*");
//          opt.addArguments("--headless");
            opt.addArguments("--no-sandbox");

            System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());

            driver=new ChromeDriver(opt);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
            driver.navigate().to("http://10.0.6.252:3000/");
    		
    		//---------------------------------------login---------------------------------------------------//
    		driver.findElement(By.xpath("/html/body/div/div/div/div/section/div/div/div[1]/div[2]/div/form/div/div/fieldset[1]/div/input")).sendKeys("admin_stetosco");
//    		driver.findElement(By.xpath("/html/body/div/div/div/div/section/div/div/div[1]/div[2]/div/form/div/fieldset/div/input")).sendKeys("superadmin@gmail.com");
//    		driver.findElement(By.xpath("/html/body/div/div/div/div/section/div/div/div[1]/div[2]/div/form/div/button")).click();
    		driver.findElement(By.xpath("/html/body/div/div/div/div/section/div/div/div[1]/div[2]/div/form/div/div/fieldset[2]/div/div/div/input")).sendKeys("admin_stetosco");
    		
//    		Thread.sleep(1000);
//    		driver.findElement(By.xpath("//input[@placeholder='Enter OTP']")).sendKeys("Overpower_123");
    		driver.findElement(By.xpath("/html/body/div/div/div/div/section/div/div/div[1]/div[2]/div/form/div/button")).click();
    		
    		boolean page_title = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[2]/nav/div[1]/div[3]/span")).isDisplayed();
    		System.out.println(page_title);
    		if (page_title){
    			System.out.println("Admin berada di Beranda");
    		}else {
    	    	System.out.println("Gagal Login");
    		}
	}

    public WebDriver getDriver() {

            return driver;
    }
}
