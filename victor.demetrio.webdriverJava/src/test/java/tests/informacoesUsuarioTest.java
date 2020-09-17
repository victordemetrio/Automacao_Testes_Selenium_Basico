package tests;

import static org.junit.Assert.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "testAdicionarUmaInformacaoAdicionalDoUsuario.csv")
public class informacoesUsuarioTest {
    private WebDriver navegador;

    @Rule
    public TestName nomeDoTeste = new TestName();

    @Before
    public void setUp(){
        navegador = Web.createChrome();
        navegador.findElement(By.linkText("Sign in")).click();
        WebElement formlinkSigniInbox = navegador.findElement(By.id("signinbox"));
        formlinkSigniInbox.findElement(By.name("login")).sendKeys("julio0001");
        formlinkSigniInbox.findElement(By.name("password")).sendKeys("123456");
        navegador.findElement(By.linkText("SIGN IN")).click();
        navegador.findElement(By.className("me")).click();
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }

    @Ignore
    public void testRemoverUmContadoDeUsuario(){
        navegador.findElement(By.xpath("//span[text()=\"+558366665555\"]/following-sibling::a")).click();
        navegador.switchTo().alert().accept();
        WebElement msgPopValidacaoTstRemovCtctUser = navegador.findElement(By.id("toast-container"));
        assertEquals("Rest in peace, dear phone!",msgPopValidacaoTstRemovCtctUser.getText());

        //nao funcionando o metodo "tirarScreenshot"
        String screenshotArquivo  = "C:\\Users\\Victor Hugo\\IdeaProjects\\victor.demetrio.webdriverJava\\src\\test\\java\\screenshot"
                + Generator.dataHoraParaArquivo()
                + nomeDoTeste.getMethodName() + ".png";
        Screenshot.tirarScreenshot(navegador,screenshotArquivo);
        //--------------------------------------------------------

        WebDriverWait aguardar = new WebDriverWait(navegador,10);
        aguardar.until(ExpectedConditions.stalenessOf(msgPopValidacaoTstRemovCtctUser));
        navegador.findElement(By.linkText("Logout")).click();
    }

    @Ignore
    public void testAdicionarUmaInformacaoAdicionaoDoUsuario(
            @Param(name = "tipo")String tipo,
             @Param(name = "contato")String contato,
             @Param(name = "mensagem")String mensagemEsperada
    ){
        navegador.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));
        WebElement canpoTypePhone = popupAddMoreData.findElement(By.name("type"));
        new Select(canpoTypePhone).selectByVisibleText(tipo);
        popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);
        popupAddMoreData.findElement(By.linkText("SAVE")).click();
        WebElement mensagemPopValidacao = navegador.findElement(By.id("toast-container"));
        assertEquals(mensagemEsperada,mensagemPopValidacao.getText());
    }

   @Ignore
    public void testValidacaoLoginDoUsuario(){
        navegador.get("http://www.juliodelima.com.br/taskit/");
        navegador.findElement(By.linkText("Sign in")).click();
        WebElement formlinkSigniInbox = navegador.findElement(By.id("signinbox"));
        formlinkSigniInbox.findElement(By.name("login")).sendKeys("julio0001");
        formlinkSigniInbox.findElement(By.name("password")).sendKeys("123456");
        navegador.findElement(By.linkText("SIGN IN")).click();
        WebElement me = navegador.findElement(By.className("me"));
        String textNoElementoMe = me.getText();
        assertEquals("Hi, Julio",textNoElementoMe);
    }

    @After
    public void tearDown(){
        navegador.close();//fecha apenas a aba
        //navegador.quit();//fecha o navegador
    }

}
/*!

@BeforeClass = Método público, sem retorno e estático usado para executar comandos antes da execução do primeiro teste contido no projeto.

@AfterClass = Método público, sem retorno e estático usado para executar comandos depois da execução do último teste contido no projeto.

@Ignore(String motivo) = Permite que testes sejam ignorados.

 */
