package Com.OpenMRS.Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

public class Element_Util {
	
private WebDriver driver;
	
	public Element_Util(WebDriver driver) {
		this.driver=driver;
	}
	public void keysEnter(By locator, String value) {
		 driver.findElement(locator).sendKeys(value+Keys.ENTER);
	}
	public WebElement getelement(By locator) {
		return driver.findElement(locator);
	}
	public WebElement doclick(By locator) {
	WebElement click= getelement(locator);
	click.click();
	return click;
	}
	public String getcurrentURL() {
		return driver.getCurrentUrl();
	}
	public void  dosendkeys(By locator, String value) {
		getelement(locator).sendKeys(value);
	}
	public WebElement doclear(By locator) {
		WebElement click= getelement(locator);
		click.clear();
		return click;
		}
	public String GetelementText(By locator) {
		return getelement(locator).getText();
	}
	public String gettitle() {
		return driver.getTitle();
	}
	public List<WebElement> getelements(By locator) {
		return driver.findElements(locator);
	}
	public int getcountOfElements(By locator) {
		return getelements(locator).size();
	}
	public String GetlistelementsText(By locator, int index) {
		List<WebElement> list=driver.findElements(locator);
		List<String> text=new ArrayList();
		for(WebElement e:list) {
			String Texts=e.getText();
			text.add(Texts);
		}	
		return text.get(index);
		//return text;
	}

	public int GetelementsTextIndexno(By locator, String value) {
		List<WebElement> list=driver.findElements(locator);
		List<String> text=new ArrayList();
		for(WebElement e:list) {
			String Texts=e.getText();
			text.add(Texts);
		}	
		return text.indexOf(value);
		//return text;
	}
	
	public boolean GetelementsTextcontains(By locator, String value) {
		List<WebElement> list=driver.findElements(locator);
		List<String> text=new ArrayList();
		for(WebElement e:list) {
			String Texts=e.getText();
			System.out.println();
			text.add(Texts);
		}	
		return text.contains(value);
		//return text;
	}
	public String textcontains(By locator, String Value) {
		String text=driver.findElement(locator).getText();
		text.contains(Value);
		return text;
	}
	
	public Select selectoption(By locator, String value) {
		WebElement Bylocator=driver.findElement(locator);
		Select select=new Select(Bylocator);
		 select.selectByVisibleText(value);
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 Bylocator.click();
		 return select;
	}
	public WebDriver Windows_handling(int index) {
		Set<String> handle=driver.getWindowHandles();
		List<String> windows=new ArrayList<String>();
		for(String e:handle) {
			windows.add(e);
		}
		 driver.switchTo().window(windows.get(index));
		return driver;
	}
	
	public WebDriverWait WebDriver_Explicit_Wait(int seconds, By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return wait;
	}
	
	public TakesScreenshot Fullpage_screenshot(String path_SSname) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File from=ts.getScreenshotAs(OutputType.FILE);
		File to=new File(path_SSname);
		try {
			Files.copy(from, to);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ts;
	}
	public TakesScreenshot Specific_page_Screenshot(By locator, String path_SSname) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		WebElement ele=driver.findElement(locator);
		File from=ele.getScreenshotAs(OutputType.FILE);
		File To=new File(path_SSname);
		
		try {
			Files.copy(from, To);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ts;	
	}
	public void impli_wait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	public ArrayList<String>  AvailableTesxts(By locator,String values) {
		List <WebElement> forms=driver.findElements(locator);
		ArrayList<String> arr=new ArrayList<String>();
		for(WebElement e:forms) {
			String all=e.getText();
			System.out.println(all);
			arr.add(all);
		}
		Assert.assertEquals(arr.contains("   "+values),true);
	return arr;
	}	
	public ArrayList<String>  EqualTesxts(By locator,String values) {
		List <WebElement> forms=driver.findElements(locator);
		ArrayList<String> arr=new ArrayList<String>();
		for(WebElement e:forms) {
			String all=e.getText();
			System.out.println(all);
			arr.add(all);
		}
		Assert.assertEquals(arr.contains(values),true);
	return arr;
	}	
}
