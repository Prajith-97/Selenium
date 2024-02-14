package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;

public class configuration {
    public static void main(String[] args) throws IOException {
        ExtentReports extentReports = new ExtentReports();
        File file = new File("C:\\JavaIntellij\\SeleniumBasics\\report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        sparkReporter.loadJSONConfig(new File("C:\\JavaIntellij\\SeleniumBasics\\src\\extentReportConfig.json"));
//        sparkReporter.config().setTheme(Theme.DARK);
//        sparkReporter.config().setReportName("ReportName");
//        sparkReporter.config().setDocumentTitle("Docs");
//        sparkReporter.config().setTimeStampFormat("dd-mm-yy hh:mm:ss");
//        sparkReporter.config().setCss("badge badge-primary{background-color:#7670278f}");
//        sparkReporter.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");
        extentReports.attachReporter(sparkReporter);

        ExtentTest test1 = extentReports.createTest("Test1")
                .log(Status.PASS, "passed")
                .log(Status.SKIP, "skipped")
                .log(Status.FAIL, "failed")
                .log(Status.INFO, "info");

        extentReports.flush();
    }
}
