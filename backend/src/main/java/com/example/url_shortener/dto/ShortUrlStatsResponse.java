package com.example.url_shortener.dto;

import java.time.LocalDateTime;

public class ShortUrlStatsResponse {

    private String shortCode;
    private String longUrl;
    private Long clickCount;
    private LocalDateTime createdAt;
    private LocalDateTime lastAccessedAt;
    private LocalDateTime expiresAt;

    public ShortUrlStatsResponse(
            String shortCode,
            String longUrl,
            Long clickCount,
            LocalDateTime createdAt,
            LocalDateTime lastAccessedAt,
            LocalDateTime expiresAt
    ) {
        this.shortCode = shortCode;
        this.longUrl = longUrl;
        this.clickCount = clickCount;
        this.createdAt = createdAt;
        this.lastAccessedAt = lastAccessedAt;
        this.expiresAt = expiresAt;
    }

    public String getShortCode() { return shortCode; }
    public String getLongUrl() { return longUrl; }
    public Long getClickCount() { return clickCount; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getLastAccessedAt() { return lastAccessedAt; }
    public LocalDateTime getExpiresAt() { return expiresAt; }
}
