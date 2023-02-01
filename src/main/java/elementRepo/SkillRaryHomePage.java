package elementRepo;

import genericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SkillRaryHomePage extends WebDriverUtility {

    public SkillRaryHomePage(WebDriver driver){
       this.driver=driver;
    }
    WebDriver driver;
    By catagories=By.xpath("//a[normalize-space()='CATEGORIES']");
    By catagoryList=By.xpath("//ul[@id='category_li']//a");
  public SkillRaryHomePage getTotalCatagories(){
      driver.findElement(catagories).click();
      int size = driver.findElements(catagoryList).size();
      System.out.println(size);
      return this;
  }
  public SkillRaryHomePage printAllCatagoryElements(){
      List<WebElement> elements = driver.findElements(catagoryList);
      for (WebElement e : elements) {
          System.out.println(e.getText());
      }
      return this;
  }
}