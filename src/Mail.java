import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {

    public static void send(String firstname,String lastname,String brief,String mail) {


        // Sender's email ID needs to be mentioned
        String from = "reda.dev.brief@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("reda.dev.brief@gmail.com", "tjnlrhjzoolxaorn");
            }

        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));

            // Set Subject: header field
            message.setSubject("Simplonline : Nouveau Brief");

            // Now set the actual message
            message.setText( "Bonjour "+firstname+" " +lastname+
                    "\n" +
                    "Votre formateur vous a assigné un le nouveau brief "+  brief +"  dans le cadre d’un projet de groupe !\n" +
                    "\n" +
                    "Rendez-vous sur la plateforme pour le consulter avec le reste de votre groupe. Définissez et créez les tâches au sein de ce projet dont vous allez vous occuper individuellement.\n" +
                    "\n" +
                    "Une fois que vous aurez chacun.e soumis vos rendus, votre formateur pourra consulter vos tâches, l'ensemble du (ou des) rendu(s) et vous évaluer.\n" +
                    "\n" +
                    "En cas de questions, contactez votre formateur \n" +
                    "\n" +
                    "A bientôt,\n" +
                    "L’équipe Simplonline.");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}