package com.example.url_shortener.controller;

import com.example.url_shortener.dto.ShortUrlStatsResponse;
import com.example.url_shortener.service.ShortUrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    private final ShortUrlService shortUrlService;

    public StatsController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<ShortUrlStatsResponse> getStats(
            @PathVariable String shortCode) {

        return shortUrlService.getByShortCode(shortCode)
                .map(shortUrl ->
                        ResponseEntity.ok(
                                new ShortUrlStatsResponse(
                                        shortUrl.getShortCode(),
                                        shortUrl.getLongUrl(),
                                        shortUrl.getClickCount(),
                                        shortUrl.getCreatedAt(),
                                        shortUrl.getLastAccessedAt(),
                                        shortUrl.getExpiresAt()
                                )
                        )
                )
                .orElse(ResponseEntity.notFound().build());
    }
}