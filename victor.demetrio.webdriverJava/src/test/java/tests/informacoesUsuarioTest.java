package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.lang.annotation.Documented;
import java.util.concurrent.TimeUnit;

//<!--Automação de Testes com Selenium WebDriver em Java Aula 06 e 07-->
public class informacoesUsuarioTest {
    private WebDriver navegador;

    @Before
    public void setUp(){
        //abrindo navegador chrome
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Victor Hugo\\IdeaProjects\\DrivesProgramacao\\chromedriver.exe");
        navegador = new ChromeDriver();
        //navegador.manage().window().maximize(); maximizar navegado
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//tempo de espera para a execuçao dos comandos
    }
    @Test
    public void testAdicionarUmaInformacaoAdicionaoDoUsuario(){
        navegador.get("http://www.juliodelima.com.br/taskit/");
        navegador.findElement(By.linkText("Sign in")).click();
        WebElement formlinkSigniInbox = navegador.findElement(By.id("signinbox"));
        formlinkSigniInbox.findElement(By.name("login")).sendKeys("julio0001");
        formlinkSigniInbox.findElement(By.name("password")).sendKeys("123456");
        navegador.findElement(By.linkText("SIGN IN")).click();

        //clicar em um link que possui a class me "Hi, Julio"
        navegador.findElement(By.className("me")).click();
        //clicar em um link que possui o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        //clicar em um button que possui o texto "+ ADD MORE DATA" atravez do xphaf //*[@id="moredata"]/div[2]/button
        navegador.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();
        //identificar a popup onde esta o formulario de id ADD MORE DATA
        //lodando com comboBox
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));
        //no comboBox de name "type" escolher a opçao "phone"
        WebElement canpoTypePhone = popupAddMoreData.findElement(By.name("type"));
        new Select(canpoTypePhone).selectByVisibleText("Phone");
        //no campo de name "contact" digitar "+558399991111"
        popupAddMoreData.findElement(By.name("contact")).sendKeys("+558399991111");
        //clicar no link que possui o texto "SAVE"que esta na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();
        //no mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
        WebElement mensagemPopValidacao = navegador.findElement(By.id("toast-container"));
        assertEquals("Your contact has been added!",mensagemPopValidacao.getText());
        //String mensagemValidacao = mensagemPopValidacao.getText();
        //assertEquals("Your contact has been added!",mensagemValidacao);
    }
    /*!
    @Test
    public void testValidacaoLoginDoUsuario(){
        //navegando para pagina do teste
        navegador.get("http://www.juliodelima.com.br/taskit/");
        //clicar no link com o texto "Sign in"
        //WebElement linkSigniIn = navegador.findElement(By.linkText("Sign in"));
        //linkSigniIn.click();
        navegador.findElement(By.linkText("Sign in")).click();
        //identificando o formulario de login ()
        WebElement formlinkSigniInbox = navegador.findElement(By.id("signinbox"));
        //"clicar" no campo com name "login" que esta dentro do form de id "signinbox"
        //digitar no campo com name "login" que esta dentro do form de id "signinbox" o texto "julio0001"
        formlinkSigniInbox.findElement(By.name("login")).sendKeys("julio0001");
        //"clicar" no campo com name "password" que esta dentro do form de id "signinbox"
        //digitar no campo com name "password" que esta dentro do form de id "signinbox" o texto "123456"
        formlinkSigniInbox.findElement(By.name("password")).sendKeys("123456");
        //(fazer o lonig)clicar no link com o texto "SIGN IN" texto em maiusculo (focar no que o usuario ver)
        navegador.findElement(By.linkText("SIGN IN")).click();
        //validar que dentro do elemento com class "me" esta com o texto "Hi, Julio"
        WebElement me = navegador.findElement(By.className("me"));
        String textNoElementoMe = me.getText();
        assertEquals("Hi, Julio",textNoElementoMe);
    }
    */
    @After
    public void tearDown(){
        //fechar o navegador
        //navegador.close();//fecha apenas a aba
        //navegador.quit();//fecha o navegador
    }

}
/*!

@BeforeClass = Método público, sem retorno e estático usado para executar comandos antes da execução do primeiro teste contido no projeto.

@AfterClass = Método público, sem retorno e estático usado para executar comandos depois da execução do último teste contido no projeto.

@Ignore(String motivo) = Permite que testes sejam ignorados.

 */
