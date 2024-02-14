import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;

public class toolTip {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/tooltip/");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        WebElement ele = driver.findElement(By.xpath("//a[text()='Tooltips']"));
        System.out.println(ele.getAttribute("title"));
    }


}
