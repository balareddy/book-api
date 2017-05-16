package com.newberry.http.client;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlBuilder {
    public String gitHubHost;
    public String clientId;

    public UrlBuilder(@NotEmpty @Value("${github.url}") String gitHubHost, @NotEmpty @Value("${github.client_id}") String clientId) {
        this.gitHubHost = gitHubHost;
        this.clientId = clientId;
    }

    public String getUrl(){
        return String.format("%s?client_id=%s", this.gitHubHost, this.clientId);
    }
}
