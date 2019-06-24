package com.luo.community.community.controller;

import com.luo.community.community.dto.AccessTokenDTO;
import com.luo.community.community.dto.GithubUser;
import com.luo.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auther:罗云继
 * @date 2019/6/24 21:57
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state")String state){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();

        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setClient_secret("403463c8957dac591152e6a9d3de39a46df498ad");
        accessTokenDTO.setClient_id("65d6aae0afc527743586");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        Object user=githubProvider.getUser(accessToken);

        //System.out.println(user.toString());
        return "index";
    }
}
