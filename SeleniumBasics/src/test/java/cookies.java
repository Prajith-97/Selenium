import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Set;

public class cookies {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        Set<Cookie> cookies = driver.manage().getCookies(); //return all the cookies
        System.out.println(cookies.size());
        for(Cookie cookie:cookies){
            System.out.println(cookie.getName());
        }
        //add cookie
        Cookie c = new Cookie("my", "123");
        driver.manage().addCookie(c);
        cookies = driver.manage().getCookies();
        System.out.println(cookies.size());

        //delete
//        driver.manage().deleteCookie(c);
//        cookies = driver.manage().getCookies();
//        System.out.println(cookies.size());

        //delete by name
        driver.manage().deleteCookieNamed("my");
        cookies = driver.manage().getCookies();
        System.out.println(cookies.size());

        //delete all cookies
        driver.manage().deleteAllCookies();
        cookies = driver.manage().getCookies();
        System.out.println(cookies.size());
    }
}
