package pl.cz.shop.sheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.cz.shop.service.EmailService;

@Component
//@RequiredArgsConstructor <- biblioteka lombok (najlepiej na youtube zobaczyc jak zainstalowac)
public class EmailScheduler {

    private final EmailService emailService;

    public EmailScheduler(EmailService emailService) {
        this.emailService = emailService;
    }

    @Scheduled(cron = "0 0 7 * * ?")
    public void reportCurrentTime() {

        emailService.sendSpam();
    }
}