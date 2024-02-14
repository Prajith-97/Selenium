import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class handles {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        String tab  = Keys.chord(Keys.CONTROL, Keys.RETURN);
        driver.findElement(By.xpath("//a[text()='About Us']")).sendKeys(tab);
        driver.findElement(By.xpath("//a[text()='Careers']")).sendKeys(tab);

        Set<String> windowsIDs = driver.getWindowHandles();
        System.out.println(windowsIDs);

        //list method
//        List<String> windowsIDList = new ArrayList<>(windowsIDs); //converting set to lists
//        String parentWindow = windowsIDList.get(0);
//        String childWindow = windowsIDList.get(1);
//        driver.switchTo().window(childWindow);

        //iterator method
//        Iterator<String> it = windowsIDs.iterator();
//        String parent = it.next();
//        String child = it.next();

        for(String win:windowsIDs){
            driver.switchTo().window(win);//switch to particular tab and then perform the validations
            if(driver.getTitle().equalsIgnoreCase("Amazon.jobs: Help us build Earth’s most customer-centric company.")){
                System.out.println("switched to the career tab");
                break;
            }


        }

        // getWindowHandle : return the id of the single browser window. Datatype:String
        // getWindowHandles : return the id of the multiple browser window.
    }
}
