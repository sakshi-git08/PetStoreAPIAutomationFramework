package com.api.tests.Store;

import lombok.Data;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

@Data
public class OrderResponse {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;
}
