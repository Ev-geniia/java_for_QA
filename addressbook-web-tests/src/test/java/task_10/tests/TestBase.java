package task_10.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import task_10.appmanager.ApplicationManager;

public class TestBase {
  WebDriver wd;

  protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeSuite (alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite (alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

}
