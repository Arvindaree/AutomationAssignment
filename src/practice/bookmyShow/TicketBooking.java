package practice.bookmyShow;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TicketBooking 
{

	public static void main(String[] args)
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://in.bookmyshow.com/explore/home/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[.='Hyderabad']")).click();
		
		
		driver.findElement(By.xpath("//div[.='Maharaja']")).click();
		driver.findElement(By.xpath("//div[@class='sc-1vmod7e-2 hhYlrx']")).click();
		driver.findElement(By.xpath("(//*[@class='sc-vhz3gb-3 ksLpgw'])[2]")).click();
		

	}

}
