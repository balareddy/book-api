package com.newberry.service;

import com.newberry.http.client.GitHubClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

@Component
public class GitHubClientService {

    private final GitHubClient gitHubClient;

    @Inject
    public GitHubClientService(@NotNull GitHubClient gitHubClient){
        this.gitHubClient = gitHubClient;
    }

    public boolean authenticate(String clientId){
        final ResponseEntity<String> response = this.gitHubClient.authenticate(clientId);
        return HttpStatus.OK.equals(response.getStatusCode());
    }

}
