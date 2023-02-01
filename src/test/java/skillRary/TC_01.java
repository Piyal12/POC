package skillRary;

import elementRepo.SkillRaryHomePage;
import genericUtility.BaseClass;
import genericUtility.DataProviderUtils;
import org.testng.annotations.Test;
import testData.TestData;

public class TC_01 extends BaseClass {
    SkillRaryHomePage homePage;
    @Test()
    public void validateProductList() {
        homePage = new SkillRaryHomePage(driver);
        homePage.getTotalCatagories().
                printAllCatagoryElements();
    }
}
