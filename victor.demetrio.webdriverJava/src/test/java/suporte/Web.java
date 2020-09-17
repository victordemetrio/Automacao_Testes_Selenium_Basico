package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {
    public static final String USERNAME = "";
    public static final String AUTOMATE_KEY = "";
    public static final String URL_BROWSERSTACK = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Victor Hugo\\IdeaProjects\\DrivesProgramacao\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.get("http://www.juliodelima.com.br/taskit/");
        return navegador;
    }
    public static WebDriver createbrowserstack(){
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "80");
        caps.setCapability("name", "victordemetrio1's First Test");

        WebDriver navegador = null;
        try {
            navegador = new RemoteWebDriver(new URL(URL_BROWSERSTACK),caps);
            navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            navegador.get("http://www.juliodelima.com.br/taskit/");
        } catch (MalformedURLException e) {
            System.out.println("Falha ao iniciar serviços Browserstack");
            e.printStackTrace();
        }

        return navegador;
    }
}
