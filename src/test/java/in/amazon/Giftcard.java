package in.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class Giftcard extends Index{
public void giftstore() {	
WebElement gift=driver.findElement(By.xpath("//h2[contains(text() , 'The Gift Cards Store')]"));
String xtxt="The Gift Cards Store";
String txt = gift.getText();
SoftAssert copy = new SoftAssert();
copy.assertEquals(xtxt, txt);
}
}