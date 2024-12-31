package com.api.services;

import com.api.base.BaseService;
import com.api.models.request.UserRequest;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.get;

public class UserService extends BaseService {
    private static final String BASE_PATH = "/v2/user";

    public Response createUser(UserRequest payload){
        return post(payload, BASE_PATH);
    }

    public Response loginUser(Map<String, String> queryParam, Map<String, String> pathParam){
        return get(BASE_PATH + "/login", queryParam,pathParam);
    }
}
