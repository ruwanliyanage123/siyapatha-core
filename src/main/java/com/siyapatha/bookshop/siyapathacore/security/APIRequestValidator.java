package com.siyapatha.bookshop.siyapathacore.security;

import java.util.UUID;

public class APIRequestValidator {

    private static APIRequestValidator instance;

    public static APIRequestValidator getInstance() {
        if (instance == null) {
            instance = new APIRequestValidator();
        }
        return instance;
    }

    public boolean isValidRequest(String apiKey) {
        return APIKeyHolder.getInstance().isValidAPIKey(apiKey);
    }

    public String createAPIKey(ClientCredentials clientCredentials) {
        if (APIKeyHolder.getInstance().isNewCredentials(clientCredentials)) {
            final String apiKey = UUID.randomUUID().toString();
            APIKeyHolder.getInstance().putClientCredentials(apiKey, clientCredentials);
            return apiKey;
        }
        return null;
    }
}
