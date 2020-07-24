package suporte;

import com.sun.jna.platform.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;

public class Screenshot {
    public static void tirarScreenshot(WebDriver navegador, String arquivo){
        File screenshotAtual = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
        try {
            //FileUtils.copyFile(screenshotAtual, new File(arquivo)); nao cuncionando
            FileUtils.getInstance();
        } catch (Exception e){
            System.out.println("Problemas ao salvar Screenshot" + e.getMessage());
        }

    }
}
