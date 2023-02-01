package skillRary;

import genericUtility.BaseClass;
import genericUtility.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestData;

public class TC_02 extends BaseClass {
    String actualTitle;
    @Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
    public void validatePositiveTitleTest(TestData testData){
        actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(testData.expected),"Home Page Title not Matched");
        System.out.println(testData.expected);
    }
    @Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
    public void validateNegativeTitleTest(TestData testData){
        actualTitle= driver.getTitle();
        Assert.assertFalse(actualTitle.contains(testData.expected),"Home Page Title not Matched");
        System.out.println(testData.expected);
    }
}
