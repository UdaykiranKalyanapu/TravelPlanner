package com.inn.travel.com.inn.travel.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping(path = "/user")
public interface UserRest {
    @PostMapping(path="/signup")
public ResponseEntity<String> signup(@RequestBody(required = true) Map<String,String> requestMap);
}
