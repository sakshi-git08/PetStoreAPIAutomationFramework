package com.api.tests.User;

import com.api.models.request.UserRequest;
import com.api.models.response.UserLoginResponse;
import com.api.models.response.UserResponse;
import com.api.services.UserService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class TestUser {
    UserService userService = new UserService();
    UserRequest userRequest ;
    UserLoginResponse userLoginResponse;


    @Test(description = "create a user for petstore")
    public void testCreateUser(){
        userRequest = new UserRequest(2, "Anju", "Anju", "Lakshman", "anjulakshman@gmail.com","anju@123","7151792512",1);
        Response response = userService.createUser(userRequest);
        UserResponse userResponse = response.as(UserResponse.class);
        int code = userResponse.getCode();
        Assert.assertEquals(code, 200);

    }



    @Test(description = "Verify login", dependsOnMethods = "testCreateUser")
    public void testLoginUser(){
        String userName = userRequest.getUserName();
        String password = userRequest.getPassword();
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("username", userName);
        queryParams.put("password", password);
        Response response = userService.loginUser(queryParams, null);
        userLoginResponse = response.as(UserLoginResponse.class);
        int code = userLoginResponse.getCode();
        Assert.assertEquals(code, 200);
        String msg = userLoginResponse.getMessage();
        Assert.assertEquals(msg, "logged in user session:" + splitString(userLoginResponse));

    }

    public String splitString(UserLoginResponse userLoginResponse){
        String s[] = userLoginResponse.getMessage().split(":");
        return s[1];
    }
}
