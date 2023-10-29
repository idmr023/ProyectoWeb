package modelo;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
    
   
    public String getRandom(){
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
    
    public boolean sendEmail(Empleado emp){
        boolean test = false;
        
        String toEmail = emp.getEmp_correo();
        String fromEmail = "idmr_02@outlook.com";
        String password = "mividaesmiaA" ;
        String senderName = "Hotel Antares";
        
        try {
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.office365.com");
            pr.setProperty("mail.smtp.port", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
        
            //Sesion
            
            Session session = Session.getInstance(pr, new Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(fromEmail, password);
                }
            });
            
            Message mess = new MimeMessage(session);
            
            mess.setFrom(new InternetAddress(fromEmail, senderName));
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            mess.setSubject("Nuevo inicio de sesión detectado");
            
            String emailContent = "<html>" +
                "<head>" +
                "<style>" +
                "    body {" +
                "        margin: 0;" +
                "        padding: 0;" +
                "        box-sizing: border-box;" +
                "    }" +
                "    h1, h2, h3, h4, h5 {" +
                "        font-family: 'Montserrat', sans-serif;" +
                "    }" +
                "    p, a, td, th, form, input, button, div, span, i {" +
                "        font-family: 'Poppins', sans-serif;" +
                "        text-decoration: none;" +
                "    }" +
                "    svg {" +
                "        position: absolute;" +
                "        width: 100%;" +
                "        z-index: -1;" +
                "    }" +
                "    footer {" +
                "        display: flex;" +
                "        justify-content: center;" +
                "        text-align: center;" +
                "        padding: 20px;" +
                "        background: #81E3E5;" +
                "        color: #FFFFFF;" +
                "    }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 1440 320\">" +
                "    <path fill=\"#0099ff\" fill-opacity=\"1\" d=\"M0,192L1440,256L1440,0L0,0Z\"></path>" +
                "</svg>" +
                "<div style=\"text-align: center;\">" +
                "    <h1 style=\"color: #81E3E5;\">Nuevo inicio de sesión desde Hotel Antares</h1>" +
                "    <p>¡Hola, " + emp.getEmp_correo()+ "!</p>" +
                "    <p>Se ha detectado un nuevo inicio de sesión en tu cuenta.</p>" +
                "    <p>Fecha y hora: " + new Date() + "</p>" +
                "    <hr>" +
                "</div>" +
                "</body>" +
                "<footer>" +
                "    <p>Copyright©2022 Hotel Antares. All rights reserved</p>" +
                "    <p>Privacy Policy | Terms and Conditions</p>" +
                "</footer>" +
                "</html>";

                mess.setContent(emailContent, "text/html; charset=utf-8");
                Transport.send(mess);
            
            test = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return test;
    }
}
