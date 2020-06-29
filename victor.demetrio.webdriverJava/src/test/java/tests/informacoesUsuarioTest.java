package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class informacoesUsuarioTest {
    @Test
    //<!--Automação de Testes com Selenium WebDriver em Java Aula 06 e 07-->
    public void testAdicionarUmaInformacaoAdicionaoDoUsuario(){
        //abrindo navegador chrome
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Victor Hugo\\Google Drive\\DrivesProgramacao\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        //navegando para pagina do teste
        navegador.get("https://www.youtube.com/");

        //validaçao
        assertEquals(1,1);

    }
}
