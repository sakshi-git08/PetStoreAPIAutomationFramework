package com.api.tests.Store;

import com.api.base.BaseService;
import com.api.services.StoreService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class TestCreateOrder extends BaseService {
    OrderRequest orderRequest;
    StoreService storeService = new StoreService();
    OrderResponse orderResponse;

    @Test
    public void createOrder() {

        orderRequest = new OrderRequest.OrderRequestBuilder()
                .id(2)
                .petId(12)
                .quantity(2)
                .shipDate("2024-12-30T14:31:46.912+0000")
                .status("placed")
                .complete(Boolean.TRUE).build();
        Response response = storeService.createOrder(orderRequest);
        orderResponse = response.as(OrderResponse.class);
        System.out.println("shipDate :: " + orderResponse.getShipDate());
//        Instant date = orderResponse.getShipDate();
//        Assert.assertFalse(date != null);

    }
}
