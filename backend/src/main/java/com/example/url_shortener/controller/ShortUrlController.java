package com.example.url_shortener.controller;

import com.example.url_shortener.dto.CreateShortUrlRequest;
import com.example.url_shortener.dto.ShortUrlResponse;
import com.example.url_shortener.service.ShortUrlService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<ShortUrlResponse> createShortUrl(
            @Valid @RequestBody CreateShortUrlRequest request) {

        var shortUrl = shortUrlService.createShortUrl(
                request.getLongUrl(),
                request.getExpiresAt()
        );

        String fullShortUrl =
                shortUrlService.buildShortUrl(shortUrl.getShortCode());

        return ResponseEntity.status(201)
                .body(new ShortUrlResponse(
                        shortUrl.getShortCode(),
                        fullShortUrl
                ));
    }
}
