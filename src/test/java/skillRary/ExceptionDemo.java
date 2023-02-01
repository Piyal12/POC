package skillRary;

import genericUtility.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExceptionDemo extends RuntimeException{
    public static void main(String[] args) {

        TargetInvocation ti = new TargetInvocation();

        // Get all methods of TargetInvocationClass:
        Method[] m = TargetInvocation.class.getMethods();
        try {
            // Invoke the first method of the class:
            m[0].invoke(ti);
        }
        catch(Exception e) {
            // Print the wrapper exception:
            System.out.println("Wrapper exception: " + e);

            // Print the 'actual' exception:
            System.out.println("Underlying exception: " + e.getCause());
        }
    }
    @Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
    public void validatePositiveTitleTest(TestData testData) throws InvocationTargetException {
        System.out.println(testData.expected);
    }
}
