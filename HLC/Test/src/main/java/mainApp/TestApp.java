package mainApp;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class TestApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile testprofile = profile.getProfile("default-release");
		FirefoxOptions fo = new FirefoxOptions();
		fo.setProfile(testprofile);
		WebDriver driver = new FirefoxDriver(fo);

		driver.get("https://www.savethevideo.com/es/home");
		String enlace = "https://es.pornhub.com/view_video.php?viewkey=ph6334751cc59ca";// sc.nextLine();
		System.out.print("Enlace: " + enlace);
		sc.close();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0, l = enlace.length(); i < l; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.findElement(By.cssSelector("#url")).sendKeys(enlace.charAt(i) + "");
		}

//		CharSequence cs = new StringBuilder(enlace);
//		System.out.println(cs);
//		driver.findElement(By.cssSelector("#url")).sendKeys(cs);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.cssSelector(
				"#gatsby-focus-wrapper > main > section:nth-child(1) > div > div.sm\\:text-center.md\\:max-w-2xl.md\\:mx-auto.lg\\:mx-0.lg\\:col-span-8.lg\\:text-left > div.mt-8.sm\\:mx-auto.sm\\:text-center.lg\\:mx-0.lg\\:text-left > form > button"))
				.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.cssSelector("a.flex:nth-child(3)")).click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("a.flex:nth-child(3)")).click();
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
