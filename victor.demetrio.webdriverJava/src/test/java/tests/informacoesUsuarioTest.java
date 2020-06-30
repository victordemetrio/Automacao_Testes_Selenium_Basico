package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.annotation.Documented;
import java.util.concurrent.TimeUnit;

public class informacoesUsuarioTest {
    @Test
    //<!--Automação de Testes com Selenium WebDriver em Java Aula 06 e 07-->
    public void testAdicionarUmaInformacaoAdicionaoDoUsuario(){
        //abrindo navegador chrome
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Victor Hugo\\Google Drive\\DrivesProgramacao\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        //navegador.manage().window().maximize(); maximizar navegado
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//tempo de espera para a execuçao dos comandos

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

        //fechar o navegador
        //navegador.close();//fecha apenas a aba
        navegador.quit();//fecha o navegador

        //validaçao
        assertEquals(1,1);

    }
}
/*!
    O método findElement provavelmente é o método que você mais vai utilizar
    durante sua trajetória na automação de testes com Selenium WebDriver.
    Isso porque ele retorna um objeto do tipo WebElement que representa um objeto qualquer contido na página,
    por exemplo, um botão, um campo, uma caixa de textos, etc.

    Alguns dos métodos mais utilizados em um WebElement são:

    click()

    Para clicar em um determinado elemento.

    sendKeys(String texto)

    Para atribuir um texto a um elemento, esse método pode ser mesclado com o uso da classe Keys,
    que possibilita, por exemplo, o digitar de teclas especiais como Shift, Enter, Backspace, etc.

    https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/Keys.html

    getText()

    Retorna o texto contido entre o abrir e fechar da tag.
    No código <a id="mensagem">Este é meu texto</a>, o getText() retornaria "Este é meu texto".

    clear()

    Limpa um campo que já possui um valor default.

    getAttribute(String atributo)

    Retorna o texto contido em um atributo.
    No código <a id="mensagem">Este é meu texto</a>, o getAttribute("id") retornaria "mensagem".

 */
