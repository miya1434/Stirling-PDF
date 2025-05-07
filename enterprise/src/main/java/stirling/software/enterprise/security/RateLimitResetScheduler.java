package stirling.software.enterprise.security;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RateLimitResetScheduler {

    private final IPRateLimitingFilter rateLimitingFilter;

    @Scheduled(cron = "0 0 0 * * MON") // At 00:00 every Monday TODO: configurable
    public void resetRateLimit() {
        rateLimitingFilter.resetRequestCounts();
    }
}
