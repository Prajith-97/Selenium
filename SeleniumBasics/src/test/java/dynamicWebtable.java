import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class dynamicWebtable {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.id("input-username")).sendKeys("demo");
        driver.findElement(By.id("input-password")).sendKeys("demo");
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        driver.findElement(By.xpath("//button[@class='btn-close']")).click();

        //sales
        driver.findElement(By.xpath("//nav[@id='column-left']//ul//li[@id='menu-sale']")).click();
        driver.findElement(By.linkText("Orders")).click();

        //Table
        String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
        System.out.println(text);

        //text.indexOf("(")+1 will return the index of the "("
        //text.indexOf("Pages")-1 will return the index of the "Pages"
        //text.substring is used to the get the value in between
        int total = Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
        System.out.println(total);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        for(int p=1;p<=total;p++){
            WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//li[@class='page-item active']//span"));
            System.out.println("Current Page Number ="+activePage.getText());


            List<WebElement> totalRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr"));
            int count = totalRows.size();
            System.out.println("Total Rows = "+count);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebElement nextPage = driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='>']"));
            jse.executeScript("arguments[0].click()", nextPage);
        }
    }
}