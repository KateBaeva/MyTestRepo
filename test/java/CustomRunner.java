import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;

/**
 * Created by katsiaryna_bayeva on 2/22/17.
 */
public class CustomRunner {
    public static void main(String[] args) {

        TestNG testNG = new TestNG();
        testNG.addListener(new TestListenerAdapter());
        testNG.addListener(new CustomListener());

        final XmlSuite XmlSuite = new XmlSuite();
        XmlSuite.setName("KateCalculator");
        XmlSuite.setSuiteFiles(new ArrayList<String>() {
            {
                add("/Users/katsiaryna_bayeva/Documents/com.epam.java_testing.katsiaryna_bayeva.hometask4/src/main/resources/calculator/calculator.xml");
            }
        });


        testNG.setXmlSuites(new ArrayList<XmlSuite>() {
            {
                add(XmlSuite);
            }
        });

        testNG.run();

    }
}
