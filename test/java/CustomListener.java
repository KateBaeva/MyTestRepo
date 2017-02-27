import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * Created by katsiaryna_bayeva on 2/22/17.
 */
public class CustomListener implements ISuiteListener {

    public void onStart(ISuite iSuite) {
        System.out.println("Suite started " + iSuite.getName());
    }



    public void onFinish(ISuite iSuite) {
        System.out.println("Suite finished " + iSuite.getName());

    }
}
