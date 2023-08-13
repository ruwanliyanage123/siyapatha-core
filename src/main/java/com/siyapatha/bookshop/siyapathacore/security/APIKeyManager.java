package com.siyapatha.bookshop.siyapathacore.security;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class APIKeyManager {

    private final Map<String, ClientCredentials> credentialsMap = new HashMap<>();
    private static APIKeyManager instance;

    public static APIKeyManager getInstance() {
        if (instance == null) {
            instance = new APIKeyManager();
        }
        return instance;
    }

    private APIKeyManager(){
    }

    public String createAPIKey(ClientCredentials clientCredentials) {
        if (isNewCredentials(clientCredentials)) {
            final String apiKey = UUID.randomUUID().toString();
            putClientCredentials(apiKey, clientCredentials);
            return apiKey;
        }
        return null;
    }


    public void putClientCredentials(String apiKey, ClientCredentials credentials) {
        credentialsMap.put(apiKey, credentials);
    }

    public boolean isValidAPIKey(String apiKey) {
        return credentialsMap.containsKey(apiKey);
    }

    public boolean isNewCredentials(ClientCredentials credentials) {
        return !credentialsMap.containsKey(credentials.getClientID());
    }
}
