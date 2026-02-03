package com.example.url_shortener.controller;

import com.example.url_shortener.entity.ShortUrl;
import com.example.url_shortener.service.ShortUrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/r")
public class RedirectController {

    private final ShortUrlService shortUrlService;

    public RedirectController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        Optional<ShortUrl> optionalShortUrl =
                shortUrlService.getByShortCode(shortCode);

        if (optionalShortUrl.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ShortUrl shortUrl = optionalShortUrl.get();

        if (shortUrl.getExpiresAt() != null &&
                shortUrl.getExpiresAt().isBefore(LocalDateTime.now())) {
            return ResponseEntity.status(HttpStatus.GONE).build();
        }

        shortUrlService.recordClick(shortUrl);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(shortUrl.getLongUrl()))
                .build();
    }
}