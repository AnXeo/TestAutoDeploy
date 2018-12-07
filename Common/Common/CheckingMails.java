package Common;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;

import Constant.Constant;

public class CheckingMails {

	public static String check(String prefix, String emailAddress) {
		String activeLink = "";
		{
			try {
				Properties properties = new Properties();
				properties.put("mail.pop3s.host", "pop.gmail.com");
				properties.put("mail.pop3s.port", "995");
				properties.put("mail.pop3s.starttls.enable", "true");

				Session emailSession = Session.getInstance(properties, new javax.mail.Authenticator() {
					protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
						return new javax.mail.PasswordAuthentication(Constant.emailAccount, Constant.passAccount);
					}
				});
				Store store = emailSession.getStore("pop3s");
				store.connect();
				Folder emailFolder = store.getFolder("INBOX");
				emailFolder.open(Folder.READ_ONLY);
				Message[] messages = emailFolder.getMessages();
				for (int i = 0; i < 5; i++) {
					messages = emailFolder.search(new SubjectTerm(prefix + emailAddress), emailFolder.getMessages());
				}
				Message result = messages[0];
				activeLink = result.getContent().toString();

				int index1 = activeLink.indexOf(">http://");
				index1 = index1 + 1;
				int index2 = activeLink.indexOf("</a>");
				activeLink = activeLink.substring(index1, index2);
				emailFolder.close(false);
				store.close();

			} catch (NoSuchProviderException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return activeLink;
	}

}
