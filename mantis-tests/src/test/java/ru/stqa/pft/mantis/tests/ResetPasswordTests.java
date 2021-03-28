package ru.stqa.pft.mantis.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetPasswordTests extends TestBase{

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testResetPassword() throws IOException, MessagingException{
    Users users = app.db().enabledUsers();
    UserData user = users.iterator().next();
    String username = user.getName();
    String email = user.getEmail();
    Integer id = user.getId();
    String newPassword = "newpassword";

    app.guiSession().login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
    app.goTo().manageUsers();
    app.user().selectUser(username, id);

    long now = System.currentTimeMillis();
    app.user().initPasswordReset(now);

    List<MailMessage> mailMessages = app.mail().waitForMail(2, 90000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, newPassword);
    assertTrue(app.newSession().login(username, newPassword));
  }


  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
