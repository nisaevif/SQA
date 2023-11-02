package steps;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.id.Maka;
import io.cucumber.java.id.Dengan;
import io.cucumber.java.id.Ketika;

public class lihat_cari {
	private WebDriver driver;
	public lihat_cari(menu menu) {
		this.driver = menu.getDriver();
	}
	
String menu=null;
String pasien=null;
WebElement tgl=null;
WebElement plh_tgl=null;
WebElement cari=null;

	@Dengan("user berada di halaman {string}")
	public void user_berada_di_halaman(String string) {
		String sub_menu1 = driver.getPageSource();
	    if (sub_menu1.contains(string)) {
	    	System.out.println("Text: Admin telah berada di submenu " + string);
	    }else {
	    	System.out.println("Submenu " + string + " tidak dapat di akses");
	    }
	}

	@Ketika("user mencari berdasarkan nama")
	public void user_mencari_berdasarkan_nama() {
		WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[3]/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/div/div/form/div/div/table/tbody/tr[1]/td[2]"));
        String text = element.getText();
        String[] words = text.split(" ");
        String pasien = words[0] + " " + words[1];
        System.out.println("Text: " + pasien);
	         
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[3]/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/div/div/div[2]/div[1]/div/div[1]/fieldset/div/input")).sendKeys(pasien);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[3]/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/div/div/div[2]/div[1]/div/div[3]/button[2]")).click();
	}

	@Maka("sistem akan menampilkan tagihan yang dicari")
	public void sistem_akan_menampilkan_tagihan_yang_dicari() {
		String pasien_tabel = null;
	    WebElement l = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[3]/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/div/div/form/div/div/table/tbody"));
		List<WebElement> rows = l.findElements(By.tagName("tr"));
		int rows_cnt = rows.size();
		for (int i = 0;i < rows_cnt; i++) {
	         List<WebElement> colmn = rows.get(1).findElements(By.tagName("td"));
	         String r = colmn.get(1).getText();
	         System.out.println(r);
	         
	         pasien_tabel = r;
	    }
		Assert.assertEquals(pasien_tabel,pasien);
	}

	@Dengan("user telah berada di halaman {string}")
	public void user_telah_berada_di_halaman(String string) {
		String sub_menu2 = driver.getPageSource();
	    if (sub_menu2.contains(string)) {
	    	System.out.println("Text: Admin telah berada di submenu " + string);
	    }else {
	    	System.out.println("Submenu " + string + " tidak dapat di akses");
	    }
	}

	@Ketika("user memilih tanggal")
	public void user_memilih_tanggal() {
		plh_tgl = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[3]/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/fieldset/div/div/button"));
		tgl = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[3]/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/fieldset/div/div/div/div/div/div[2]/div[3]/div[4]/div[6]"));
		cari = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[3]/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/div/div/div[2]/div[1]/div/div[3]/button[2]"));
		
		plh_tgl.click();
		tgl.click();
		cari.click();
	}

	@Maka("sistem akan menampilkan tagihan sesuai tanggal yang dipilih")
	public void sistem_akan_menampilkan_tagihan_sesuai_tanggal_yang_dipilih() {
		WebElement t = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[3]/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/div/div/form/div/div/table/tbody"));
		List<WebElement> rws = t.findElements(By.tagName("tr"));
		int rws_cnt = rws.size();
		boolean filter_tgl = false;
		for (int i = 0;i < rws_cnt; i++) {
	         List<WebElement> cols = rws.get(i).findElements(By.tagName("td"));
	         
	         String c = cols.get(3).getText();
	         System.out.println(c);
	         
	         if (tgl.getAttribute("value").contains(c)) {
	        	filter_tgl = true;
	 	    	System.out.println("sistem menampilkan data sesuai tanggal yang dipilih, Tanggal " + filter_tgl);
	 	    	break;
	 	    	}
	    }
		driver.quit();
	}
}
