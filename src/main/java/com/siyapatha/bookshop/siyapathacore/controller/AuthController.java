package com.siyapatha.bookshop.siyapathacore.controller;

import com.siyapatha.bookshop.siyapathacore.security.APIKeyManager;
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
    APIKeyManager validator = APIKeyManager.getInstance();

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpHeaders> createAPIKey(@RequestBody ClientCredentials credentials) {
        if (credentials != null && credentials.getClientID() != null && credentials.getClientSecret() != null) {
            final String apiKey = validator.createAPIKey(credentials);
            if (apiKey != null) {
                HttpHeaders header = new HttpHeaders();
                header.add("X-API-KEY", apiKey);
                return new ResponseEntity<>(header, HttpStatus.CREATED);
            }
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Message", "Please contact admin");
        return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
    }
}
