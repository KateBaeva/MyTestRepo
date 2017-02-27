import com.epam.tat.module4.Timeout;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by katsiaryna_bayeva on 2/22/17.
 */
public class PositiveUnitTests extends BaseCalculatorTest {

    public PositiveUnitTests(){

    }


    private double firstNumber;
    private double secondNumber;
    private double expectedNumber;

    public PositiveUnitTests(double firstNumber, double secondNumber, double expectedNumber) {
        this.firstNumber=firstNumber;
        this.secondNumber=secondNumber;
        this.expectedNumber=expectedNumber;
    }
    @Parameters({"firstL", "secondL", "expectedL"})
    @Test(description="Check sum of two positive long numbers")
    public void SumPostiveLongNumbers(long firstL, long secondL, long expectedL){
        long result=calculator.sum(firstL, secondL);
        Assert.assertEquals(result, expectedL, "The sum is incorrect");
        checkTime();
        Timeout.sleep(2);
    }

    @Test(description="Check subtraction of double numbers", dataProvider="Data for subtraction")
    public void SubDoubleNumbers(double firstNumber, double secondNumber, double expectedNumber){
        double result=calculator.sub(firstNumber, secondNumber);
        Assert.assertEquals(result, expectedNumber);

    }

    @Test(description="Check division of even numbers", groups = {"DivEvenNumber"})
    public void DivEvenNumbers(){
        double result=calculator.div(6.0, 3.0);
        Assert.assertEquals(result, 2.0, "Result of division is incorrect");
        checkTime();
        Timeout.sleep(2);
    }


    @Test(description="Check division of non-integral numbers", dependsOnGroups = {"DivEvenNumber"})
    public void DivNonIntegralNumbers(){
        double result=calculator.div(1.5, 1.5);
        Assert.assertEquals(result, 1.0, "Result of division is incorrect");
    }

    @Test(description="Check multiplication of negative numbers")
    public void MultiNegativeNumbers(){
        long result=calculator.mult(-4, -10);
        Assert.assertEquals(result, 40, "Result of multiplication is incorrect");
    }

    @DataProvider(name="Data for subtraction")
    public Object[][]dataForSubtraction(){
        return new Object[][]{
                {2.5, 1.5, 1.0},
                {10.5, 0.5, 10.0},
                {3.5, 3.5, 0},
                {4.5, 2.5, 2},
        };
    }
}

