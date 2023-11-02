package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.id.*;

public class menu {
	private LoginHelper loginHelper;
    private WebDriver driver;
	    public menu(LoginHelper loginHelper) {
	    	this.loginHelper = loginHelper;
	        this.driver = this.loginHelper.getDriver();
		}
	    
		
	    @Dengan("akses menu {string}")
	    public void dokter_atau_perawat_akses_menu(String menu) throws InterruptedException {
	        Thread.sleep(2000);

	        String baseUrl = "http://10.0.6.252:3000/";
//	        String baseUrl = "https://royaldent.stetosco.com/";

	        driver.get(baseUrl+menu);
	    }
	    public WebDriver getDriver() {
	        return driver;
	    }
}
