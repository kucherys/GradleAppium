import capabilities.Capabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LaunchPage;

import java.io.IOException;

public class DemoTest extends Capabilities {

    LaunchPage launchPage;

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
//        service = startServer();
        service.stop();
        driver = capabilities("digibank-0.0.6-debug.apk");
    }

    @Test
    public void verify_launching_page() {
        launchPage = new LaunchPage(driver);
        launchPage.verifyLogo();
        System.out.println(launchPage.getWelcomeTitle());
        Assert.assertEquals(launchPage.getWelcomeTitle(),"Welcome to");

    }

    @AfterTest
    public void tearDown()
    {
//        driver.quit();
        service.stop();
        System.out.println("Appium server stopped");

    }
}
