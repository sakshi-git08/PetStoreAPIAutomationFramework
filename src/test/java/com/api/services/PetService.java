package com.api.services;

import com.api.base.BaseService;
import com.api.models.request.AddPetRequest;
import com.api.models.request.UserRequest;
import io.restassured.response.Response;

public class PetService extends BaseService {
    private static final String BASE_PATH = "/v2/pet";

    public Response createPet(AddPetRequest payload){
        return post(payload, BASE_PATH);
    }
}
