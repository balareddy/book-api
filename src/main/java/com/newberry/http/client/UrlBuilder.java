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
        StringBuilder url = new StringBuilder();
        url.append(this.gitHubHost);
        url.append("?client_id=");
        url.append(this.clientId);
        return url.toString();
    }
}
