package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.AccessTokenDto;
import com.example.springbootdemo.dto.GithubUser;
import com.example.springbootdemo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.client.id}")
    public String clientId;
    @Value("${github.client.secret}")
    public String clientSecret;
    @Value("${github.redirect.url}")
    public String redirectUrl;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
//        accessTokenDto.setClient_id("Iv1.48f3a31b14c54577");
        accessTokenDto.setClient_id(clientId);
        accessTokenDto.setClient_secret(clientSecret);
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_url(redirectUrl);
        accessTokenDto.setState(state);

        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser user=githubProvider.getUser(accessToken);
        System.out.println(user.getName());

        return "index";
    }
}
