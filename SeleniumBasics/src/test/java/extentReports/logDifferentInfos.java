package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.vandeseer.easytable.structure.cell.paragraph.Markup;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class logDifferentInfos {
    public static void main(String[] args) {
        ExtentReports extentReports = new ExtentReports();
        File file = new File("C:\\JavaIntellij\\SeleniumBasics\\report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);

        ExtentTest test1 = extentReports.createTest("Test1")
                .log(Status.PASS, "passed")
                .log(Status.SKIP, "skipped")
                .log(Status.FAIL, "<b>failed</b>")//to show message in bold
                .log(Status.INFO, "<i>info</i>");//to show message in italic
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\">\n" +
                "<suite name=\"All Test Suite\">\n" +
                "\n" +
                "     <test name=\"Login-CHROME\">\n" +
                "         <parameter name=\"browser-name\" value=\"chrome\"/>\n" +
                "         <parameter name=\"password\" value=\"secret\"/>\n" +
                "        <classes>\n" +
                "           <class name=\"runner.testRunner\"/>\n" +
                "       </classes>\n" +
                "    </test>";
        String json = "[\n" +
                "{\"name\":\"jeri\",\"salary\":\"20000\",\"age\":\"3\"},\n" +
                "{\"name\":\"test\",\"salary\":\"30000\",\"age\":\"13\"}\n" +
                "]";

        //pass xml data to extent report
        extentReports.createTest("xml data")
                        .pass(MarkupHelper.createCodeBlock(xml, CodeLanguage.XML));//markupHelper is a class.
        //pass json data to extent report
        extentReports.createTest("json data")
                        .log(Status.PASS, MarkupHelper.createCodeBlock(json,CodeLanguage.JSON));

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        //add collections to the extent reports
        extentReports.createTest("Collection Data")
                .log(Status.PASS, MarkupHelper.createOrderedList(numbers)) //data will be displayed in numbering format
                        .pass(MarkupHelper.createUnorderedList(numbers));//data will be displayed in bullet points
        //highlight message
        extentReports.createTest("Highlight Message")
                .log(Status.FAIL, MarkupHelper.createLabel("Failed", ExtentColor.RED));
        //Exception
        try{
            int num = 5/0;
        }catch (Exception e){
            extentReports.createTest("Exception1")
                    .info(e);
        }

        Throwable t = new RuntimeException("Runtime Exception");
        extentReports.createTest("Exception2")
                .info(t);



        extentReports.flush();
    }
}
