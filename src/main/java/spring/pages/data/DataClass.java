package spring.pages.data;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import spring.utils.BrowserUtil;
import spring.utils.Driver;

import java.util.ArrayList;
import java.util.List;

public class DataClass {

    @FindBy(xpath = "(//img[@src])[1]")
    public WebElement imageSrc1;

    @FindBy(xpath = "(//img[@src])[2]")
    public WebElement imageSrc2;

    @FindBy(xpath = "(//img[@src])[3]")
    public WebElement imageSrc3;

    @FindBy(xpath = "(//img[@src])[4]")
    public WebElement imageSrc4;

    @FindBy(xpath = "(//img[@src])[5]")
    public WebElement imageSrc5;

    @FindBy(css = "span[id='name']")
    public WebElement name;

    public DataClass() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void iteration(){
        List<String> list = new ArrayList<>();
        BrowserUtil.waitPlease(2);
        list.add(imageSrc1.getAttribute("src"));
        BrowserUtil.waitPlease(2);
        list.add(imageSrc2.getAttribute("src"));
        BrowserUtil.waitPlease(2);
        list.add(imageSrc3.getAttribute("src"));
        BrowserUtil.waitPlease(2);
        list.add(imageSrc4.getAttribute("src"));
        BrowserUtil.waitPlease(2);
        list.add(imageSrc5.getAttribute("src"));

        String header = name.getText().replace(" " , "_").toLowerCase();

        list.forEach(ls -> System.out.println(ls.contains(header)));
        System.out.println(header);
        for(int i = 0; i < list.size(); i++) {
            String n = list.get(i);
            System.out.println(n);
            String lastName = n.substring((n.length()-15), n.length()-4);
            System.out.println(lastName);
            int _index = lastName.indexOf("_");
            System.out.println(lastName.substring(_index));

        }
    }
}
