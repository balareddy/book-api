package com.newberry.http.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

@Component
public class GitHubClient {

    private final UrlBuilder urlBuilder;

    @Inject
    public GitHubClient(@NotNull UrlBuilder urlBuilder){
        this.urlBuilder = urlBuilder;
    }

    public ResponseEntity<String> authenticate(String clientId) {
        final RestTemplate restTemplate = new RestTemplate();
        //TODO: Need to finish the authentication properly. currently just creating a succes response.
        return restTemplate.getForEntity(this.urlBuilder.getUrl(), String.class, clientId);
    }
}
