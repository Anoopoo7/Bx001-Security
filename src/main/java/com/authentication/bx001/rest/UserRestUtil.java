package com.authentication.bx001.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserRestUtil {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${custom.baseUrl}")
    String baseUrl;

    @Value("${custom.verifyUser}")
    String verifyUser;

    @Value("${custom.anonymusUser}")
    String anonymusUser;

    private String uriBuilder(String baseUrl, String endpint) {
        StringBuilder builder = new StringBuilder();
        builder.append(baseUrl);
        builder.append(endpint);
        return builder.toString();
    }

    public Map<String, String> verifyUser(Map<String, String> tokenData) {
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(tokenData, null);
        ResponseEntity<Map<String, String>> result = restTemplate.exchange(
                uriBuilder(baseUrl, verifyUser), HttpMethod.POST, requestEntity,
                new ParameterizedTypeReference<Map<String, String>>() {
                });
        return result.getBody();
    }

    public Map<String, String> createAnonymusUser() {
        ResponseEntity<Map<String, String>> result = restTemplate.exchange(
                uriBuilder(baseUrl, anonymusUser), HttpMethod.GET, null,
                new ParameterizedTypeReference<Map<String, String>>() {
                });
        return result.getBody();
    }

}
