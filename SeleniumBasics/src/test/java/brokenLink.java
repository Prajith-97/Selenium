import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class brokenLink {
    public static void main(String[] args) throws IOException {
        int brokenLink = 0;
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.deadlinkcity.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(WebElement link:links){
            String url = link.getAttribute("href");
            if(url==null || url.isEmpty()){
                System.out.println("Empty");
                continue;
            }
            URL linkUrl = new URL(url); //convert each url into a link
            HttpURLConnection httpconn = (HttpURLConnection) linkUrl.openConnection();//open connection
            httpconn.connect();
            if(httpconn.getResponseCode()>400){
                System.out.println("Broken Link " +url);
                brokenLink = brokenLink+1;
            }

        }
        System.out.println(brokenLink);
    }
}
