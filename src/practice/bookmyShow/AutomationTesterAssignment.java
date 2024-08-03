package practice.bookmyShow;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomationTesterAssignment 
{

	public static void main(String[] args) throws InterruptedException 
	{
		//webdriver setup
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//opening web application 
		driver.get("https://www.fitpeo.com/");
		
		WebElement revenueCalculator=driver.findElement(By.xpath("(//div[.='Revenue Calculator'])[2]"));
		revenueCalculator.click();
		
		WebElement sliderElementScale=driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-root')]"));
		Actions actions=new Actions(driver);
		actions.scrollToElement(sliderElementScale).perform();
		actions.scrollByAmount(0, 300).perform();
		
		WebElement slider=driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-thumb')]"));
		WebElement textbox=driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input')]"));
		
		System.out.println(slider.getLocation().getX());
		actions.dragAndDropBy(slider, 94, 0).perform();
		String textboxValue=textbox.getAttribute("value");
		
		if(textboxValue.equals("823"))
		{
			System.out.println("text box is adjusted according to slider");
		}
		else
		{
			System.out.println("text box is not adjusted according to slider");
		}
		
		textbox.clear();
		Thread.sleep(2000);
		int beforeSliderPosition=slider.getLocation().getX();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("document.getElementById(':r0:').value='560'");
		int afterSliderPosition=slider.getLocation().getX();
		if(beforeSliderPosition!= afterSliderPosition)
		{
			System.out.println("slider is adjusted according to textbox value");
		}
		else
		{
			System.out.println("slider is not adjusted according to textbox value");
		}
		
		actions.scrollByAmount(0, 500).perform();
		
		List<WebElement> boxesList=driver.findElements(By.xpath("//div[@class='MuiBox-root css-4o8pys']"));
		System.out.println(boxesList.size());
		String[] cptArray= {"CPT-99091","CPT-99453","CPT-99454","CPT-99474"};
		List<String> cptList=Arrays.asList(cptArray);
		System.out.println(cptList.size());
		for (WebElement box : boxesList) 
		{
			String header=box.findElement(By.tagName("p")).getText();
			System.out.println(header);
			if(cptList.contains(header))
			{
				WebElement checkbox=box.findElement(By.tagName("input"));
				checkbox.click();
			}
		}
		
		String totalRecReimb=driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-hocx5c'])[4]")).getText();
		System.out.println(totalRecReimb);
		
		if(totalRecReimb.equals("$110700"))
		{
			System.out.println(" total recurring reimbusment is matched");
		}
		else
			System.out.println("total recurring reimbusment is mismatched");
	}

}
