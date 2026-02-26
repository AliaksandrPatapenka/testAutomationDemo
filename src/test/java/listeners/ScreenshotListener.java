package listeners;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;  // ← вот это исправь
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.ByteArrayInputStream;

public class ScreenshotListener implements TestWatcher {



    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        WebDriver driver = (WebDriver) context.getStore(ExtensionContext.Namespace.GLOBAL).get("driver");
        if (driver != null){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Скриншот при падении", new ByteArrayInputStream(screenshot));
     }
    }
}
