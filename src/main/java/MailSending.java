import org.testng.annotations.AfterClass;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class MailSending {

    @AfterClass
    public static void main(String[] args) throws UnsupportedEncodingException {
        Properties props = new Properties();
        System.out.println("started");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        // get Session
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("clucloud.automation@gmail.com", "wrkt qvcy womg hdln");
            }
        });

        // compose message
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("no_reply@gmail.com", "no_reply@gmail.com"));
            msg.setReplyTo(InternetAddress.parse("to mail id", false));
            msg.setSubject("Test Report by Automation", "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("saikiran.kondala@clucloud.com"));
            BodyPart messageBodyPart = new MimeBodyPart();
            String additionalText = "<p>Please find attached the automation report for the latest test run.\n This report provides an overview of the test results and any issues encountered during the testing process.</p>";
            messageBodyPart.setText(additionalText);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            String managerReports = "test-output/Reports/CluCloud_Automation_Report.html";  // Replace with the actual file name
            String filename = System.getProperty("user.dir") + "/" + managerReports;
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            messageBodyPart.setHeader("Content-ID", "image_id");
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("<h1>Clucloud Automation final report</h1>", "text/html");
            multipart.addBodyPart(messageBodyPart);

            // Set the multipart message to the email message
            msg.setContent(multipart);

            // Send message
            Transport.send(msg);
            System.out.println("Email Sent Successfully");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
