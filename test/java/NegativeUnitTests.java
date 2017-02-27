import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by katsiaryna_bayeva on 2/22/17.
 */
public class NegativeUnitTests extends BaseCalculatorTest {

    public NegativeUnitTests(){

    }

    private long firstNumber;
    private long secondNumber;
    private long expectedNumber;
    private long firstL;
    private long secondL;
    private long expectedL;

    public NegativeUnitTests(long firstNumber, long secondNumber, long expectedNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expectedNumber = expectedNumber;
    }

    @Parameters({"firstL", "secondL", "expectedL"})
    @Test(description = "Check sum of long and double numbers", dependsOnMethods = {"SubNegativeByPositive"})
    public void SumNegativeNumbers(long firstL, long secondL, long expectedL) {
        long sum = calculator.sum(firstL, secondL);
        Assert.assertEquals(sum, expectedL, "The sum of negative long numbers is incorrect");
    }

    @Test(description = "Check subtraction Negative/Positive", dataProvider = "Data for subtraction, Negative/Positive")
    public void SubNegativeByPositive(long firstNumber, long secondNumber, long expectedNumber) {
        long result = calculator.sub(firstNumber, secondNumber);
        Assert.assertEquals(result, expectedNumber);
    }

    @Test(description = "Check division by Zero", groups = {"OperationWithZero"}, expectedExceptions = { NumberFormatException.class })
    public void DivByZero() throws Exception {
        long result = calculator.div(6, 0);
    }

    @Test(description = "Check multiplication by Zero", groups = {"OperationWithZero"})
    public void MultWithZero() {
        double result = calculator.mult(3.0, 0.0);
        Assert.assertEquals(result, 0.0, "Result of multiplication is incorrect");
    }

    @Test(description = "Check subtraction with negative numbers", dependsOnGroups = {"OperationWithZero"})
    public void SubNegativeNumbers() {
        long result = calculator.sub(-4, -10);
        Assert.assertEquals(result, 6, "Result of subtraction is incorrect");
    }

    @DataProvider(name = "Data for subtraction, Negative/Positive")
    public Object[][] dataForSubtraction() {
        return new Object[][]{
                {6, -3, 9},
                {8, -2, 10},
                {10, -1, 11},
                {20, -10, 30}
        };
    }
}
