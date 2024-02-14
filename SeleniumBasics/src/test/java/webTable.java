import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class webTable {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("pen");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        String totalPages = driver.findElement(By.xpath("//span[@class='s-pagination-item s-pagination-disabled']")).getText();
        System.out.println(totalPages);
        int total = Integer.parseInt(totalPages);
        for(int i=0;i<total;i++){
            List<WebElement> elements = driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//div[@data-asin]//div[@class='a-section a-spacing-none a-spacing-top-small s-title-instructions-style']//h2//a//span"));
              for(WebElement ele:elements){
                  System.out.println(ele.getText());
              }
              driver.findElement(By.xpath("//a[text()='Next']")).click();
              driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }

    }
}
