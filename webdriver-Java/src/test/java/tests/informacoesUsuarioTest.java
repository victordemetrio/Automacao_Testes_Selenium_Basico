package tests;

import static org.junit.jupiter.api.Assertions.*;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class informacoesUsuarioTest {

    private WebDriver navegador;

    @BeforeEach
    public void setUp(){
        //abrindo navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Victor Hugo\\Drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.manage().window().maximize();

        //navengando para pagina taskit
        navegador.get("http://www.juliodelima.com.br/taskit/");
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {


        //clicar no link "sing in"
        navegador.findElement(By.linkText("Sign in")).click();

        //identificando o formulario de Login
        WebElement formulatioSignInBOx = navegador.findElement(By.id("signinbox"));

        //digitar no campo com NAME "login" que esta dentro do formilario de ID "signinbox" o texto "julio0001"
        formulatioSignInBOx.findElement(By.name("login")).sendKeys("julio001");

        //digitar no campo com NAME "password" que esta dentro do formilario de ID "signinbox" o texto "123456"
        formulatioSignInBOx.findElement(By.name("password")).sendKeys("123456");

        //clicar no link com o texto "SIGN IN" para efetuar o login
        navegador.findElement(By.linkText("SIGN IN")).click();

        //clicar em link que tem class "me"
        navegador.findElement(By.className("me")).click();

        //cliclar em link que tem o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        //clicar no botoa atraves do seu xpath //button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //identificar a popup onde esta o formulario de id addmoredata
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        //na combo de name "type" escolher uma opcao "phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");//interagindo com combo box

        //no campo de name "contact" digitar "+5511999999"
        popupAddMoreData.findElement(By.name("contact")).sendKeys("+5511999999");

        //clicar no link de text "save" que esta no popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        //na mensagem de id "toast-container" validar que o texto é "your contact has been added!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals("Your contact has been added!", mensagem);

        //

        //validar que dentro do elemento class "me" esta o texto "hi, julio"
        //WebElement me = navegador.findElement(By.className("me"));
        //String textoNoElementoMe = me.getText();
        //assertEquals("Hi, Julio",textoNoElementoMe);


    }
    @Test
    public void asserts(){
        //validacao
        assertEquals(1,1);
        assertTrue(true,"E-True");

    }

    @AfterEach
    public  void  tearDown(){
        //fechar navegador
        navegador.quit();
    }
    // @Ignore(String motivo) Permite que testes sejam ignorados.

}
