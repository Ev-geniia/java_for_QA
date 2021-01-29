package task_9.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import task_9.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoAddNewContactPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
            && isElementPresent(By.name("submit"))) {
      return;
    }
    click(By.linkText("add new"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("lastname"),contactData.getLastname());
    type(By.name("address"),contactData.getAddress());
    type(By.name("home"),contactData.getPhone());
    type(By.name("email"),contactData.getEmail());

    if(creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void selectContact(int index) {
    wd.findElements(By.xpath("//img[@alt='Details']")).get(index).click();

  }

  public void initContactModification() {
    click(By.name("modifiy"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void initContactDeletion() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectContactHomePage(int index) {
    wd.findElements(By.xpath("//td/input")).get(index).click();

  }

  public void confirmContactDeletion() {
    wd.switchTo().alert().accept();
  }

  public void createContact(ContactData contact) {
    gotoAddNewContactPage();
    fillContactForm(new ContactData("firstname", "lastname", "address", "2128506", "mail@mail.com", "test1"), true);
    submitContactCreation();
    returnToHomePage();

  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//td/input"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("selected[]"));
    for(WebElement element : elements) {
      String firstname = element.getText();
      ContactData contact = new ContactData(firstname, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }

}
