package modelo;
import java.util.Properties;
import javax.mail.*;
import javax.swing.JOptionPane;
import javax.mail.internet.*;

public class JCMail {

    private String from = "idmr_02@outlook.com";
    private String password = "mividaesmiaA";
    private InternetAddress[] addressTo;
    private String Subject = "Inicio de sesión reciente en su cuenta";
    private String MessageMail = "Su cuenta ha sido recién abierta";

    public JCMail() {
    }

    public void SEND() {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.office365.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");

            Session session = Session.getDefaultInstance(props);
            session.setDebug(false);

            MimeMessage mimemessage = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress(getFrom());
            mimemessage.setFrom(addressFrom);
            mimemessage.setRecipients(Message.RecipientType.TO, addressTo);
            mimemessage.setSubject(getSubject());
            mimemessage.setText(getMessage());

            Transport.send(mimemessage);
            System.out.println("El correo se envió correctamente.");
            JOptionPane.showMessageDialog(null, "Correo enviado. Enjoy!!!");
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    public void setFrom(String mail) {
        this.from = mail;
    }

    public String getFrom() {
        return this.from;
    }

    public void setPassword(char[] value) {
        this.password = new String(value);
    }

    public String getPassword() {
        return this.password;
    }

    public void setTo(String mails) {
        String[] tmp = mails.split(",");
        addressTo = new InternetAddress[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            try {
                addressTo[i] = new InternetAddress(tmp[i]);
            } catch (AddressException ex) {
                ex.printStackTrace();
            }
        }
    }

    public InternetAddress[] getTo() {
        return this.addressTo;
    }

    public void setSubject(String value) {
        this.Subject = value;
    }

    public String getSubject() {
        return this.Subject;
    }

    public void setMessage(String value) {
        this.MessageMail = value;
    }

    public String getMessage() {
        return this.MessageMail;
    }
}
