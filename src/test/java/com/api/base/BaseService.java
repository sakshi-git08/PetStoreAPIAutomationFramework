package com.api.base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseService {
    private static final String BASE_URL = "https://petstore.swagger.io/";
    private RequestSpecification requestSpecification;

    public BaseService() {
        requestSpecification = given().baseUri(BASE_URL);
    }

    protected Response post(Object payload, String endpoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).log().all().post(endpoint);
    }

    protected Response get(String endpoint, Map<String, String> queryParam, Map<String, String> pathParam) {
        applyParams(requestSpecification, queryParam, pathParam, endpoint);
        return requestSpecification.contentType(ContentType.JSON).log().all().when().get(endpoint);
    }

    public void applyParams(RequestSpecification requestSpecification, Map<String, String> queryParam, Map<String, String> pathParam, String endpoint) {
        if (queryParam != null) {
            requestSpecification.queryParams(queryParam);
        }
        if (pathParam != null) {
            endpoint = replaceWithPathParam(endpoint, pathParam);
        }
    }

    private String replaceWithPathParam(String endpoint, Map<String, String> pathParam) {
        for (Map.Entry<String, String> entry : pathParam.entrySet()) {
            endpoint = endpoint.replace("{" + entry.getKey() + "}", entry.getValue());
        }
        return endpoint;
    }

    public DateTimeFormatter date() {
//        OffsetDateTime currentDateTime = OffsetDateTime.now(); // Current time in UTC
        ZonedDateTime currentDateTime = ZonedDateTime.now(ZoneOffset.UTC); // Get UTC time

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"); // Correct pattern with 'T' escaped

        // Format the current date-time into the required format
        String dynamicShipDate = currentDateTime.format(formatter);
        return DateTimeFormatter.ofPattern(dynamicShipDate);
    }

}
