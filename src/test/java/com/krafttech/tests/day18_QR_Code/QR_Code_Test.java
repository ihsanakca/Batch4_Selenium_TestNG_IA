package com.krafttech.tests.day18_QR_Code;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.krafttech.pages.LoginPage;
import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class QR_Code_Test {
    @Test
    public void qR_Code_Test() throws IOException, NotFoundException {

        WebDriver driver = Driver.get();
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get("https://goqr.me/");

        String urlText="https://www.krafttechexlab.com/login";

        WebElement textArea = driver.findElement(By.id("qrcode-field-text-text"));

        textArea.sendKeys(urlText);

        BrowserUtils.waitFor(3);

        String qrCodeUrl = driver.findElement(By.id("qrcode-preview-image")).getAttribute("src");

        URL url=new URL(qrCodeUrl);

        BufferedImage bufferedImage= ImageIO.read(url);

        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);

        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));

        Result result = new MultiFormatReader().decode(binaryBitmap);

        String resultText = result.getText();

        driver.get(resultText);

        LoginPage loginPage=new LoginPage();
        loginPage.login();

        driver.quit();


    }
}
