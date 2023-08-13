package com.siyapatha.bookshop.siyapathacore.security;

import java.util.HashMap;
import java.util.Map;

class APIKeyHolder {

    private static APIKeyHolder instance;

    private APIKeyHolder(){
    }

    public static APIKeyHolder getInstance(){
        if(instance == null){
            instance = new APIKeyHolder();
        }
        return instance;
    }

    private final Map<String, ClientCredentials> credentialsMap = new HashMap<>();

    ClientCredentials getCredentials(String apiKey) {
        return credentialsMap.get(apiKey);
    }

    void putClientCredentials(String apiKey, ClientCredentials credentials) {
        credentialsMap.put(apiKey, credentials);
    }

    boolean isValidAPIKey(String apiKey) {
        return credentialsMap.containsKey(apiKey);
    }

    boolean isNewCredentials(ClientCredentials credentials) {
        return !credentialsMap.containsKey(credentials.getClientID());
    }
}
