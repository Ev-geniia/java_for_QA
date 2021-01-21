package task_6.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import task_6.model.ContactData;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("lastname"),contactData.getLastname());
    type(By.name("address"),contactData.getAddress());
    type(By.name("home"),contactData.getPhone());
    type(By.name("email"),contactData.getEmail());
  }

  public void selectContact() {
    click(By.xpath("//img[@alt='Details']"));
  }

  public void initContactModification() {
    click(By.name("modifiy"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void initContactDeletion() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectContactHomePage() {
    click(By.xpath("//td/input"));
  }

  public void confirmContactDeletion() {
    wd.switchTo().alert().accept();
  }
}
