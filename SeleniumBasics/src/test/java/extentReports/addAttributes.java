package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class addAttributes {
    public static void main(String[] args) {
        ExtentReports extentReports = new ExtentReports();
        File file = new File("C:\\JavaIntellij\\SeleniumBasics\\report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);

        ExtentTest test1 = extentReports.createTest("Test1")
                .pass("Test 1 passed")
                .assignAuthor("Tester 1")
                .assignCategory("smokeTest")
                .assignDevice("Chrome");

        extentReports.createTest("Test2")
                .fail("Test 2 passed")
                .assignAuthor("Tester 1")
                .assignCategory("SanityTest")
                .assignDevice("Edge");

        extentReports.createTest("Test3")
                .pass("Test 3 passed")
                .assignAuthor("Tester 1", "Tester 2", "Tester 3")
                .assignCategory("Sanity Test", "Smoke Test")
                .assignDevice("Edge", "FireFox", "Chrome", "IE");
        extentReports.flush();

    }
}
