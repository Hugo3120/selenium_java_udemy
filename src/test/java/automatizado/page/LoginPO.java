package automatizado.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {
    
    //#region Região dos WebElements

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;
    //#endregion Região dos WebElements

    //#region Construtor
    
    /**
     * Contrutor padrão para criação de uma nova instancia da pagina de login.
     * @param driver Driver da pagina de login.
     */

    public LoginPO(WebDriver driver) {
        super(driver);
        
    }
    //#endregion Construtor

    //#region Metodos


    /**
     * Metodo que obtem a mensagem disparada na tela.
     * @return Texto da mensagem
     */
    public String obterMensagem(){
        return this.spanMensagem.getText();
    }
    /**
     * Metodo que tenta executar a acão de logar no sistema.
     * @param email Email para tentativa de login.
     * @param senha Senha para tentativa de login.
     */
    public void executarAcaoDeLogar(String email, String senha){
         escrever(inputEmail, email);
         escrever(inputSenha,  senha);
         buttonEntrar.click();
    }
    
    
}
//#endregion Metodos
