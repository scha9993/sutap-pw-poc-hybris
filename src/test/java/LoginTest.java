import com.sysco.brakes.qe.webui.function.Login;
import com.syscolab.qe.core.playwright.ui.BaseBrowser;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseBrowser {
    SyscoLabPW page;
    SoftAssert softAssert;
    Login login;

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext iTestContext){
        iTestContext.setAttribute("feature", "Playwright - PWSS");
        page=getPage("Default");
        login = new Login(page);
    }

    @BeforeMethod(alwaysRun = true)
    public void declareSoftAssert(){
        softAssert = new SoftAssert();
    }

    @Test(priority = 0, description = "Verify logging to the Hybris")
    public void LoginTest() throws InterruptedException {
        login.loginToHybris();
    }

}
