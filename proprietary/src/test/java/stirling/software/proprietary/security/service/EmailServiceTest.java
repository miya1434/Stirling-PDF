package stirling.software.proprietary.security.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.multipart.MultipartFile;
import stirling.software.common.model.ApplicationProperties;
import stirling.software.proprietary.security.model.api.Email;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @Mock
    private ApplicationProperties applicationProperties;

    @Mock
    private ApplicationProperties.Mail mailProperties;

    @Mock
    private MultipartFile fileInput;

    @InjectMocks
    private EmailService emailService;

    @Test
    void testSendEmailWithAttachment() throws MessagingException {
        // Mock the values returned by ApplicationProperties
        when(applicationProperties.getMail()).thenReturn(mailProperties);
        when(mailProperties.getFrom()).thenReturn("no-reply@stirling-software.com");

        // Create a mock Email object
        Email email = new Email();
        email.setTo("test@example.com");
        email.setSubject("Test Email");
        email.setBody("This is a test email.");
        email.setFileInput(fileInput);

        // Mock MultipartFile behavior
        when(fileInput.getOriginalFilename()).thenReturn("testFile.txt");

        // Mock MimeMessage
        MimeMessage mimeMessage = mock(MimeMessage.class);

        // Configure mailSender to return the mocked MimeMessage
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);

        // Call the service method
        emailService.sendEmailWithAttachment(email);

        // Verify that the email was sent using mailSender
        verify(mailSender).send(mimeMessage);
    }
}
