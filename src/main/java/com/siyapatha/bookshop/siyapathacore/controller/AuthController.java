package com.siyapatha.bookshop.siyapathacore.controller;

import com.siyapatha.bookshop.siyapathacore.security.APIRequestValidator;
import com.siyapatha.bookshop.siyapathacore.security.ClientCredentials;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    APIRequestValidator validator = new APIRequestValidator();

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createAPIKey(@RequestBody ClientCredentials credentials) {
        if (credentials != null) {
            final String apiKey = validator.createAPIKey(credentials);
            if (apiKey != null) {
                HttpHeaders header = new HttpHeaders();
                header.add("X-API-KEY", apiKey);
                return new ResponseEntity<>(header, HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>("API Key already exists", HttpStatus.BAD_REQUEST);
    }
}
