package genericUtility;

import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import testData.TestData;

import java.lang.reflect.Method;

public class DataProviderUtils {
    @DataSupplier(runInParallel = true)
    public StreamEx<TestData> getData(Method method){
        return TestDataReader.use(XlsxReader.class)
                .withTarget(TestData.class)
                .withSource(IpathContants.excelPath)
                .read()
                .filter(testData -> testData.testCaseName.equalsIgnoreCase(method.getName()));

    }
 /*   @DataSupplier(runInParallel = true)
    public StreamEx<TestData> loginData(Method method){
        return TestDataReader.use(XlsxReader.class)
                .withTarget(TestData.class)
                .withSource(IpathContants.loginexcelPath)
                .read()
                .filter(testData -> testData.testCaseName.equalsIgnoreCase(method.getName()));
    }*/
}