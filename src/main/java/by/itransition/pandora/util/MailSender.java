package by.itransition.pandora.util;

import by.itransition.pandora.model.VerificationToken;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */
public class MailSender {

    private static final Logger LOGGER = LogManager.getLogger(MailSender.class);

    private static final String MAIL_PROP_SMTP_HOST = "mail.smtp.host";
    private static final String MAIL_PROP_SMTP_SOCKETFACTORY_CLASS = "mail.smtp.socketFactory.class";
    private static final String MAIL_PROP_SMTP_SOCKETFACTORY_FALLBACK = "mail.smtp.socketFactory.fallback";
    private static final String MAIL_PROP_SMTP_PORT = "mail.smtp.port";
    private static final String MAIL_PROP_SMTP_SOCKETFACTORY_PORT = "mail.smtp.socketFactory.port";
    private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
    private static final String MAIL_DEBUG = "mail.debug";
    private static final String MAIL_STORE_PROTOCOL = "mail.store.protocol";
    private static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";

    private static final String MAIL_SENDER_ADDRESS = "mail.sender.address";
    private static final String MAIL_SENDER_PASSWORD = "mail.sender.password";


    public void sendVerificationEmail(String receiverAddress, VerificationToken verificationToken) {
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", Manager.getProperty(MAIL_PROP_SMTP_HOST, Manager.mailPropertiesRB));
        props.setProperty("mail.smtp.socketFactory.class", Manager.getProperty(MAIL_PROP_SMTP_SOCKETFACTORY_CLASS, Manager.mailPropertiesRB));
        props.setProperty("mail.smtp.socketFactory.fallback", Manager.getProperty(MAIL_PROP_SMTP_SOCKETFACTORY_FALLBACK, Manager.mailPropertiesRB));
        props.setProperty("mail.smtp.port", Manager.getProperty(MAIL_PROP_SMTP_PORT, Manager.mailPropertiesRB));
        props.setProperty("mail.smtp.socketFactory.port", Manager.getProperty(MAIL_PROP_SMTP_SOCKETFACTORY_PORT, Manager.mailPropertiesRB));
        props.put("mail.smtp.auth", Manager.getProperty(MAIL_SMTP_AUTH, Manager.mailPropertiesRB));
        props.put("mail.debug", Manager.getProperty(MAIL_DEBUG, Manager.mailPropertiesRB));
        props.put("mail.store.protocol", Manager.getProperty(MAIL_STORE_PROTOCOL, Manager.mailPropertiesRB));
        props.put("mail.transport.protocol", Manager.getProperty(MAIL_TRANSPORT_PROTOCOL, Manager.mailPropertiesRB));

        String senderAddress = Manager.getProperty(MAIL_SENDER_ADDRESS, Manager.mailPropertiesRB);
        String senderPassword = Manager.getProperty(MAIL_SENDER_PASSWORD, Manager.mailPropertiesRB);

        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderAddress, senderPassword);
                    }
                });
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(senderAddress));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverAddress, false));
            msg.setSubject("Registration Confirmation");
            msg.setText("You registration confirmation link: " +
                    "http://localhost:8080/registrationConfirm?token=" + verificationToken.getToken());
            msg.setSentDate(new Date());
            Transport.send(msg);
        } catch (MessagingException e) {
            LOGGER.log(Level.ERROR, "Can`t send a mail, cause: " + e);
        }
    }

}
