package in.amazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Index {
	
static WebDriver driver;
	@BeforeClass
	public void launchtheapplication(){
		 WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		String url=("https://www.amazon.in/");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String currenturl=driver.getCurrentUrl();
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(url,currenturl,"url is wrong");
	}
	
      @DataProvider(name="data")
       public Object []searchdata() {
       Object []srcname= {"iphone16"};
       return srcname;
      }
      
     @Parameters ({"username","password"})  
       @Test(priority=1)
   	public void loginapp(String usname,String pwd) {
    	   driver.get("https://www.amazon.in/");
    	   WebElement find=driver.findElement(By.id("nav-link-accountList-nav-line-1"));	
    	   find.click();
    	   WebElement username=driver.findElement(By.id("ap_email"));	
    	   username.sendKeys(usname);
    	  	WebElement next=driver.findElement(By.id("continue"));	
	        next.click();
	        WebElement nextstep=driver.findElement(By.id("ap_password"));	
	        nextstep.sendKeys(pwd);
	   
	   WebElement nextstep1=driver.findElement(By.id("signInSubmit"));	
	   nextstep1.click();
       }
       
       @Test(priority=2,dataProvider="data")
       public void search(String txt) { 
    	   WebElement search=driver.findElement(By.id("twotabsearchtextbox"));	
    	   search.sendKeys(txt);
    	   System.out.println(txt);
	search.sendKeys(Keys.ENTER);
       }
	

	@Test(priority=3)
	public void findinfmobiles() {
	List<WebElement>phone=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	for(int i=0;i<phone.size();i++) {
	String name=phone.get(i).getText();
		System.out.println(name);
	}	
	}
@Test(priority=4)
public void priceofparticular() {
WebElement price=driver.findElement(By.xpath("//span[text()='Apple iPhone 16 Plus (128 GB) - Teal']//preceding::span[text()='Apple iPhone 16 (512 GB) - Ultramarine']"));
		price.click();
	}
	
}
	
	
	
	
       

	
	

		

