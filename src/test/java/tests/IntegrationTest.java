package tests;
//
//
//
//import com.automation.remarks.testng.GridInfoExtractor;
//import com.automation.remarks.testng.UniversalVideoListener;
//import com.automation.remarks.video.annotations.Video;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//
//import java.net.URL;
//
////import static com.automation.remarks.testng.test.TestNGRemoteListenerTest.startGrid;
//import static org.testng.Assert.fail;
//
//
//@Listeners(UniversalVideoListener.class)
//public class IntegrationTest {
//
//    RemoteWebDriver driver;
//
//    @BeforeClass
//    public void setUp() throws Exception {
//        URL hubUrl = new URL("http://localhost:4444/wd/hub");
//      //  driver = new RemoteWebDriver(hubUrl, DesiredCapabilities.chrome());
//        String nodeIp = GridInfoExtractor.getNodeIp(hubUrl, driver.getSessionId().toString());
//        System.setProperty("video.remote", "true");
//        System.setProperty("remote.video.hub", nodeIp);
//    }
//
//    @Test
//    @Video
//    public void test() throws InterruptedException {
//        driver.get("http://automation-remarks.com");
//    }
//}
