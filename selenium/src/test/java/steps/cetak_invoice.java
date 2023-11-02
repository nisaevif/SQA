package steps;

import java.io.File;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.id.Dengan;
import io.cucumber.java.id.Ketika;
import io.cucumber.java.id.Maka;

public class cetak_invoice {
	private WebDriver driver;
	public cetak_invoice(menu menu) {
		this.driver = menu.getDriver();
	}
	
	
	@Dengan("user berada di submenu invoice")
	public void user_berada_di_submenu_invoice() {
		//---------------------------------------akses bayar------------------------------------------------//
				driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[3]/div/div[2]/div/div/div/div/div/div/div[1]/ul/li[3]/a")).click();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
				String menu = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[3]/div/div[2]/div/div/div/div/div/div/div[2]/div[3]/div/div/div/div[1]/h4")).getText();
				
				Assert.assertTrue("Nama menu tidak sesuai : " + menu, menu.equals("Bayar"));
	}

	@Ketika("user klik cetak pada salah satu daftar invoice")
	public void user_klik_cetak_pada_salah_satu_daftar_invoice() {
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[3]/div/div[2]/div/div/div/div/div/div/div[2]/div[3]/div/div/form/div/div/div[1]/table/tbody/tr/td[8]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[3]/div/div[2]/div/div/div/div/div/div/div[2]/div[3]/div/div/form/div/div/div[1]/table/tbody/tr/td[8]/div/ul/li[2]/a")).click();
	}

	@Maka("sistem mengunduh data invoice")
	public void sistem_mengunduh_data_invoice() throws InterruptedException {
		String downloadDir = "src/test/resources/download";

        // Konfigurasi ChromeOptions untuk menentukan direktori unduhan
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--download.default_directory=" + downloadDir);

        Thread.sleep(3000); 
        // Periksa apakah file yang diharapkan ada di direktori tujuan unduhan
        String expectedFileName = "file.pdf";
        File downloadedFile = new File(downloadDir + "/" + expectedFileName);
        if (downloadedFile.exists()) {
            System.out.println("File berhasil diunduh.");
        } else {
        	throw new AssertionError("File gagal diunduh.");
        }
        driver.quit();
	}
}
