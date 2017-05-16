package com.newberry.controller;

import com.newberry.model.Person;
import com.newberry.service.BookService;
import com.newberry.service.GitHubClientService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/")
public class GitHubClientController {
    private final GitHubClientService gitHubClientService;

    @Autowired
    public GitHubClientController(@NotNull GitHubClientService gitHubClientService) {
        this.gitHubClientService = gitHubClientService;
    }

    @RequestMapping(value="github/clientId/{clientId}", method= RequestMethod.GET)
    public Boolean authenticate(@PathVariable @NotEmpty String clientId) {
        return this.gitHubClientService.authenticate(clientId);
    }
}
