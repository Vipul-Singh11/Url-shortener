package com.example.url_shortener.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

public class CreateShortUrlRequest {

    @NotBlank(message = "Long URL must not be empty")
    @URL(message = "Invalid URL format")
    private String longUrl;

    private LocalDateTime expiresAt;

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}