package testCases;

import java.io.IOException;
import java.util.Objects;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import BasicPackage.DriverInstance;
import BasicPackage.DataGenerators;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import Pages.*;

public class TC_001_LoginValid extends DriverInstance {
    @Description("Description : Test Login Feature in Amazon Website")
    @Test(groups = {"UAT", "SIT", "Smoke"}, dataProvider = "LoginValid",
            description = "Description : User be able to login to Amazon website using valid credentials")
    @Severity(SeverityLevel.CRITICAL)

    public void tc_001_LoginValid(String uname, String pass)
        throws IOException {
        amazonPage amazonPage = new amazonPage(getDriver());

        amazonPage
                .waitForPagLoad()
                .MouseHoverAccountList()
                .clickSignButton()
                .enterMobileNumberOrEmail(uname)
                .clickContinueButton()
                .enterPassword(pass)
                .clickSignInButton();
    }
        @DataProvider(parallel = true)
    public Object[][] LoginValid() throws Exception {
        Object[][] testObjArray = DataGenerators.getTestData(
                Objects.requireNonNull(TC_001_LoginValid.class.getClassLoader().getResource(
                        "testdata/testdatalogin.xlsx")).getFile(),
                "LoginValid");
        return(testObjArray);
    }

}
