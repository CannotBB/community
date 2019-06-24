package com.luo.community.community.provider;

import com.alibaba.fastjson.JSON;
import com.luo.community.community.dto.AccessTokenDTO;
import com.luo.community.community.dto.GithubUser;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Component;




/**
 * @auther:罗云继
 * @date 2019/6/24 22:10
 */
@Component
@Slf4j
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        //url 是官网提供的post请求地址
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string=response.body().string();

            //返回的res  access_token=0ab36263f692fdb772ec00ce29124c656695f5a7&scope=user&token_type=bearer
            String token=string.split("&")[0].split("=")[1];
            System.out.println(token);
            return token;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();

            String string=response.body().toString();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        }catch (Exception e){
            log.info("出了问题");
        }
        return null;
    }
}
