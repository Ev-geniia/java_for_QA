package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class UserHelper extends HelperBase{
  public UserHelper(ApplicationManager app) {
    super(app);
  }

  public void selectUser(String username, int userId) {
    type(By.id("search"), username);
    click(By.xpath("//form[@id='manage-user-filter']/fieldset/input[7]")); //apply filter
    click(By.cssSelector("a[href='manage_user_edit_page.php?user_id=" + userId + "']"));
  }

  public void initPasswordReset(long now) {
    click(By.xpath("//fieldset/span/input")); //reset password
  }
}
