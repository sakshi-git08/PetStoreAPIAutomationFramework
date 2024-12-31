package com.api.services;

import com.api.base.BaseService;
import com.api.tests.Store.OrderRequest;
import io.restassured.response.Response;

public class StoreService extends BaseService {
    private static final String BASE_PATH = "/v2/store";

    public Response createOrder(OrderRequest payload){
        return post(payload, BASE_PATH + "/order");
    }
}
