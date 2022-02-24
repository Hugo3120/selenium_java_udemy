package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação das novas PagesObjects
 * Toda as pages devem ser herdadas desta classe.
 */
public abstract class BasePO {

/** Driver base que será usado pelas pages*/
    protected WebDriver driver;

/**
 * Construtor base para criação da fabrica de elementos(PageFactory)
 * @param driver Driver da pagina atual.
 */
    public BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * Metodo que retorna o titulo da pagina atual
     * @return
     */
    public String obterTituloPagina(){
        return driver.getTitle();
    }

/**
 * Metodo que sabe escrever em qualquer WebElement do tipo input e da um TAB ao final.
 * @param input Input a qual será escrito
 * @param texto Texto que será escrito no Input
 */
    public void escrever(WebElement input, String texto){
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }
    

    
}
