package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class environmentDetails {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://www.redbus.com/");
        Capabilities cap = driver.getCapabilities();
//        System.out.println(cap.getBrowserName());
        //list out all the system properties
//        System.getProperties().list(System.out);
//        System.out.println(System.getProperty("os.version"));
//        System.out.println(System.getProperty("java.version"));
        ExtentReports extentReports=new ExtentReports();
        extentReports.setSystemInfo("BROWSER", cap.getBrowserName());
        extentReports.setSystemInfo("OS", System.getProperty("os.version"));
        extentReports.setSystemInfo("JAVA", System.getProperty("java.version"));
        File file = new File("C:\\JavaIntellij\\SeleniumBasics\\report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);
        ExtentTest test1 = extentReports.createTest("Test1")
                .log(Status.PASS, "passed")
                .log(Status.SKIP, "skipped")
                .log(Status.FAIL, "failed")
                .log(Status.INFO, "info");
        extentReports.flush();
    }

}
