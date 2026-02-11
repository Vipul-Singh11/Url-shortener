package com.example.url_shortener.service;

import com.example.url_shortener.entity.ShortUrl;
import com.example.url_shortener.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ShortUrlService {

    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int SHORT_CODE_LENGTH = 7;

    private final ShortUrlRepository shortUrlRepository;
    private final SecureRandom random = new SecureRandom();

    @Value("${app.base-url}")
    private String baseUrl;

    public ShortUrlService(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    public ShortUrl createShortUrl(String longUrl, LocalDateTime expiresAt) {

        Optional<ShortUrl> existing = shortUrlRepository.findByLongUrl(longUrl);
        if (existing.isPresent()) {
            return existing.get();
        }

        String shortCode = generateUniqueShortCode();

        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setLongUrl(longUrl);
        shortUrl.setShortCode(shortCode);
        shortUrl.setExpiresAt(expiresAt);
        shortUrl.setClickCount(0L);

        return shortUrlRepository.save(shortUrl);
    }

    public Optional<ShortUrl> getByShortCode(String shortCode) {
        return shortUrlRepository.findByShortCode(shortCode);
    }

    public void recordClick(ShortUrl shortUrl) {
        shortUrl.setClickCount(shortUrl.getClickCount() + 1);
        shortUrl.setLastAccessedAt(LocalDateTime.now());
        shortUrlRepository.save(shortUrl);
    }

    public String buildShortUrl(String shortCode) {
        return baseUrl + "/" + shortCode;
    }

    private String generateUniqueShortCode() {
        String code;
        do {
            code = randomBase62();
        } while (shortUrlRepository.findByShortCode(code).isPresent());
        return code;
    }

    private String randomBase62() {
        StringBuilder sb = new StringBuilder(SHORT_CODE_LENGTH);
        for (int i = 0; i < SHORT_CODE_LENGTH; i++) {
            sb.append(BASE62.charAt(random.nextInt(BASE62.length())));
        }
        return sb.toString();
    }
}
