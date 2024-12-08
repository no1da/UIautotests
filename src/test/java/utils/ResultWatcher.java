package utils;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;

import java.io.IOException;
import java.util.Base64;

public class ResultWatcher implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {

        try {
            screenshot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Attachment(value = "Снимок экрана", type = "image/png")
    public byte[] screenshot() throws IOException {
        String screenshotAsBase64 = Selenide.screenshot(OutputType.BASE64);
        return Base64.getDecoder().decode(screenshotAsBase64);
    }
}
