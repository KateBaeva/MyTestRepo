package java;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

import java.util.Date;

/**
 * Created by katsiaryna_bayeva on 2/22/17.
 */
public class BaseCalculatorTest {
    protected Calculator calculator;

    public BaseCalculatorTest(){

    }

    @BeforeSuite
    public void beforeSuite(){

        System.out.println("Before suite");
    }

    @BeforeGroups
    public void beforeGroups(){
        System.out.println("Before groups");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method");
    }

    @BeforeClass(groups="createCalculator")
    public void CreateCalculator(){
        System.out.println("Create Calculator  - Before Class Config Method");
        calculator=new Calculator();
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }

    @AfterGroups
    public void afterGroups(){
        System.out.println("After groups");
    }

    @AfterSuite
    public void aftereSuite(){
        System.out.println("After suite");
    }

    protected void checkTime(){
        System.out.println("Current time: " + new Date(System.currentTimeMillis()));
    }
}



