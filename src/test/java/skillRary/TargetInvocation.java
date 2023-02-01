package skillRary;

import genericUtility.IpathContants;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import testData.TestData;

import java.lang.reflect.Method;

public class TargetInvocation {
 /*   public void foo() {
        // Dividing by zero to intentionally throw an exception:
        System.out.println(10 / 0);

    }*/
    @DataSupplier(runInParallel = true)
    public StreamEx<TestData> getData(Method method){
        return TestDataReader.use(XlsxReader.class)
                .withTarget(TestData.class)
                .withSource(IpathContants.excelPath)
                .read()
                .filter(testData -> testData.testCaseName.equalsIgnoreCase(method.getName()));

    }
}
