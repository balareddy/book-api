package com.newberry.service;

import com.newberry.http.client.GitHubClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

@Component
public class GitHubClientAuthService implements GitHubClientService {

    private final GitHubClient gitHubClient;

    @Inject
    public GitHubClientAuthService(@NotNull GitHubClient gitHubClient){
        this.gitHubClient = gitHubClient;
    }

    @Override
    public boolean authenticate(String clientId){
        final ResponseEntity<String> response = this.gitHubClient.authenticate(clientId);
        // TODO: add the real authentication logic.
        return HttpStatus.OK.equals(response.getStatusCode());
    }

}
