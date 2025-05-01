package com.inn.travel.com.inn.travel.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class TravelUtils {

    private TravelUtils() {

    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus) {
        return new ResponseEntity<>("{\"message\":\"" + responseMessage + "\"}", httpStatus);
    }
}
